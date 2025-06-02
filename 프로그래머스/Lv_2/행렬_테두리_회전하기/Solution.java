/*
 * 프로그래머스 - 행렬 테두리 회전하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/77485
 */
package Lv_2.행렬_테두리_회전하기;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];

        int idx = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = idx++;
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            int x1 = query[0] - 1;
            int x2 = query[2] - 1;

            int y1 = query[1] - 1;
            int y2 = query[3] - 1;

            int prev = map[x1][y1];
            int min = prev;

            for (int j = y1 + 1; j <= y2; j++) {
                int temp = map[x1][j];
                map[x1][j] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            for (int j = x1 + 1; j <= x2; j++) {
                int temp = map[j][y2];
                map[j][y2] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            for (int j = y2 - 1; j >= y1; j--) {
                int temp = map[x2][j];
                map[x2][j] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            for (int j = x2 - 1; j >= x1; j--) {
                int temp = map[j][y1];
                map[j][y1] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            answer[i] = min;
        }

        return answer;
    }
}
