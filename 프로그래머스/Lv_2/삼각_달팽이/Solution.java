/*
 * 프로그래머스 - 삼각 달팽이
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/68645
 */
package Lv_2.삼각_달팽이;

class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];

        int cursorX = -1;
        int cursorY = 0;

        int num = 1;
        for (int i = 0; i < n; i++) {  // 한방향 으로 쭉

            for (int j = i; j < n; j++) { // 6..5..4..3..2..1
                if (i % 3 == 0) { // 왼쪽아래
                    cursorX++;
                } else if (i % 3 == 1) { // 오른쪽
                    cursorY++;
                } else {  // 왼쪽위
                    cursorX--;
                    cursorY--;
                }

                map[cursorX][cursorY] = num++;
            }
        }

        int idx = 0;
        int[] answer = new int[n * (n + 1) / 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (map[i][j] != 0) answer[idx++] = map[i][j];
            }
        }

        return answer;
    }
}
