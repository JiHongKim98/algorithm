/*
 * 프로그래머스 - 쿼드압축 후 개수 세기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 */
package Lv_2.쿼드압축_후_개수_세기;

class Solution {

    private int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        dfs(arr);
        return answer;
    }

    private void dfs(int[][] curr) {
        if (isPossible(curr)) {
            int num = curr[0][0];
            answer[num]++;
            return;
        }

        int half = curr.length / 2;

        dfs(split(curr, 0, 0, half));
        dfs(split(curr, 0, half, half));
        dfs(split(curr, half, 0, half));
        dfs(split(curr, half, half, half));
    }

    private boolean isPossible(int[][] curr) {
        int num = curr[0][0];

        for (int i = 0; i < curr.length; i++) {
            for (int j = 0; j < curr[0].length; j++) {
                if (curr[i][j] != num) return false;
            }
        }
        return true;
    }

    private int[][] split(int[][] curr, int row, int col, int size) {
        int[][] map = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = curr[row + i][col + j];
            }
        }
        return map;
    }
}
