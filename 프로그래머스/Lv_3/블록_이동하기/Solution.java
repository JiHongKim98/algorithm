/*
 * 프로그래머스 - 블록 이동하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/60063
 */
package Lv_3.블록_이동하기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static final int[] sp = {-1, 1};

    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][][] visit = new boolean[n][n][n][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 1, 0}); // x1, y1, x2, y2, count

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x1 = poll[0], y1 = poll[1];
            int x2 = poll[2], y2 = poll[3];
            int count = poll[4];

            if ((x1 == n - 1 && y1 == n - 1) || (x2 == n - 1 && y2 == n - 1)) return count;
            if (visit[x1][y1][x2][y2] || visit[x2][y2][x1][y1]) continue;

            visit[x1][y1][x2][y2] = true;
            visit[x2][y2][x1][y1] = true;

            for (int d = 0; d < 4; d++) {
                int nx1 = x1 + dx[d], ny1 = y1 + dy[d];
                int nx2 = x2 + dx[d], ny2 = y2 + dy[d];
                if (
                        isPossible(nx1, ny1, n) && isPossible(nx2, ny2, n) &&
                                board[nx1][ny1] == 0 && board[nx2][ny2] == 0
                ) {
                    queue.add(new int[]{nx1, ny1, nx2, ny2, count + 1});
                }
            }

            if (x1 == x2) {  // 수평 -> 수직
                for (int s : sp) {
                    if (
                            isPossible(x1 + s, y1, n) && isPossible(x2 + s, y2, n) &&
                                    board[x1 + s][y1] == 0 && board[x2 + s][y2] == 0
                    ) {
                        queue.add(new int[]{x1, y1, x1 + s, y1, count + 1});
                        queue.add(new int[]{x2, y2, x2 + s, y2, count + 1});
                    }
                }
            }

            if (y1 == y2) {  // 수직 -> 수평
                for (int s : sp) {
                    if (
                            isPossible(x1, y1 + s, n) && isPossible(x2, y2 + s, n) &&
                                    board[x1][y1 + s] == 0 && board[x2][y2 + s] == 0
                    ) {
                        queue.add(new int[]{x1, y1, x1, y1 + s, count + 1});
                        queue.add(new int[]{x2, y2, x2, y2 + s, count + 1});
                    }
                }
            }
        }

        return -1;
    }

    private boolean isPossible(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
