/*
 * 프로그래머스 - [1차] 프렌즈4블록
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17679
 */
package Lv_2.일차_프렌즈4블록;

class Solution {

    private static final char EMPTY = '.';

    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        int answer = 0;

        while (true) {
            boolean[][] visited = new boolean[m][n];
            boolean found = false;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char curr = map[i][j];
                    if (curr == EMPTY) continue;

                    if (
                            curr == map[i + 1][j] &&
                                    curr == map[i][j + 1] &&
                                    curr == map[i + 1][j + 1]
                    ) {
                        visited[i][j] = true;
                        visited[i + 1][j] = true;
                        visited[i][j + 1] = true;
                        visited[i + 1][j + 1] = true;
                        found = true;
                    }
                }
            }

            if (!found) break;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] && map[i][j] != EMPTY) {
                        map[i][j] = EMPTY;
                        answer++;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                int writeRow = m - 1;

                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != EMPTY) {
                        map[writeRow][j] = map[i][j];
                        if (writeRow != i) map[i][j] = EMPTY;
                        writeRow--;
                    }
                }
            }
        }

        return answer;
    }
}
