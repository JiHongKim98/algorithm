/*
 * 프로그래머스 - 수레 움직이기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/250134
 */
package Lv_3.수레_움직이기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private static int[] rExit;
    private static int[] bExit;

    public int solution(int[][] maze) {
        int n = maze.length, m = maze[0].length;

        boolean[][][][] visited = new boolean[n][m][n][m];

        Queue<int[]> queue = new LinkedList<>();

        rExit = new int[2];
        bExit = new int[2];

        int[] start = new int[5];
        start[4] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                } else if (maze[i][j] == 2) {
                    start[2] = i;
                    start[3] = j;
                } else if (maze[i][j] == 3) {
                    rExit[0] = i;
                    rExit[1] = j;
                } else if (maze[i][j] == 4) {
                    bExit[0] = i;
                    bExit[1] = j;
                }
            }
        }

        queue.add(start);
        visited[start[0]][start[1]][start[2]][start[3]] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int rX = poll[0], rY = poll[1];
            int bX = poll[2], bY = poll[3];
            int count = poll[4];

            if (redFinish(rX, rY) && blueFinish(bX, bY)) {
                return count;
            }

            for (int ri = 0; ri < 4; ri++) {
                for (int bi = 0; bi < 4; bi++) {
                    int newRX = rX, newRY = rY;
                    if (!redFinish(rX, rY)) {
                        newRX = rX + dx[ri];
                        newRY = rY + dy[ri];
                    }

                    int newBX = bX, newBY = bY;
                    if (!blueFinish(bX, bY)) {
                        newBX = bX + dx[bi];
                        newBY = bY + dy[bi];
                    }

                    // 시작점인 경우
                    if ((newRX == start[0] && newRY == start[1]) || newBX == start[2] && newBY == start[3]) continue;

                    // 범위 검사
                    if (!isValid(newRX, newRY, n, m) || !isValid(newBX, newBY, n, m)) continue;

                    // 벽인 경우
                    if (maze[newRX][newRY] == 5 || maze[newBX][newBY] == 5) continue;

                    // 두 수레가 같은 칸에 있으면 이동 불가
                    if (newRX == newBX && newRY == newBY) continue;

                    // 두 수레가 위치를 서로 바꾸는 경우 금지
                    if ((newRX == bX && newRY == bY) && (newBX == rX && newBY == rY)) continue;

                    // 이미 방문한 위치라면 탐색 X
                    if (visited[newRX][newRY][newBX][newBY]) continue;

                    visited[newRX][newRY][newBX][newBY] = true;
                    queue.add(new int[]{newRX, newRY, newBX, newBY, count + 1});
                }
            }
        }

        return 0;
    }

    private boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    private boolean redFinish(int x, int y) {
        return x == rExit[0] && y == rExit[1];
    }

    private boolean blueFinish(int x, int y) {
        return x == bExit[0] && y == bExit[1];
    }
}
