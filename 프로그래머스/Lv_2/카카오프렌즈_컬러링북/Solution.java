/*
 * 프로그래머스 - 카카오프렌즈 컬러링북
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1829
 */
package Lv_2.카카오프렌즈_컬러링북;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};

    public int[] solution(int m, int n, int[][] picture) {
        int maxSize = 0;
        int areaCount = 0;

        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = picture[i][j];

                if (color != 0 && !visit[i][j]) {
                    areaCount++;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});

                    int count = 0;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();

                        if (visit[poll[0]][poll[1]]) continue;

                        visit[poll[0]][poll[1]] = true;
                        count++;

                        for (int k = 0; k < 4; k++) {
                            int nextRow = poll[0] + dx[k];
                            int nextCol = poll[1] + dy[k];

                            if (
                                    nextRow >= 0 && nextRow < m &&
                                            nextCol >= 0 && nextCol < n &&
                                            !visit[nextRow][nextCol] &&
                                            picture[nextRow][nextCol] == color
                            ) {
                                queue.add(new int[]{nextRow, nextCol});
                            }
                        }
                    }

                    maxSize = Math.max(maxSize, count);
                }
            }
        }

        return new int[]{areaCount, maxSize};
    }
}
