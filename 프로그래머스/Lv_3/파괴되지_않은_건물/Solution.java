/*
 * 프로그래머스 - 파괴되지 않은 건물
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/92344
 */
package Lv_3.파괴되지_않은_건물;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int col = board.length;
        int row = board[0].length;

        int[][] map = new int[col + 1][row + 1];

        for (int[] s : skill) {
            if (s[0] == 1) {
                map[s[1]][s[2]] -= s[5];
                map[s[3] + 1][s[4] + 1] -= s[5];

                map[s[1]][s[4] + 1] += s[5];
                map[s[3] + 1][s[2]] += s[5];
            } else {
                map[s[1]][s[2]] += s[5];
                map[s[3] + 1][s[4] + 1] += s[5];

                map[s[1]][s[4] + 1] -= s[5];
                map[s[3] + 1][s[2]] -= s[5];
            }
        }

        for (int i = 1; i < col + 1; i++) {
            for (int j = 0; j < row + 1; j++) {
                map[i][j] += map[i - 1][j];
            }
        }

        for (int i = 0; i < col + 1; i++) {
            for (int j = 1; j < row + 1; j++) {
                map[i][j] += map[i][j - 1];
            }
        }

        int answer = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (board[i][j] + map[i][j] >= 1) answer++;
            }
        }
        return answer;
    }
}
