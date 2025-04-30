/*
 * 프로그래머스 - 블록 게임
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42894
 */
package Lv_4.블록_게임;

import java.util.*;

class Solution {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int answer = 0;

        int boardSize = board.length;

        while (true) {
            boolean flag = false;

            boolean[][] visit = new boolean[boardSize][boardSize];

            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    int currBlock = board[i][j];

                    if (currBlock == 0 || visit[i][j]) continue;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});

                    List<int[]> block = new ArrayList<>();

                    visit[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        block.add(poll);

                        for (int d = 0; d < 4; d++) {
                            int nextX = poll[0] + dx[d];
                            int nextY = poll[1] + dy[d];
                            if (
                                    nextX >= 0 && nextX < boardSize &&
                                            nextY >= 0 && nextY < boardSize &&
                                            !visit[nextX][nextY] && board[nextX][nextY] == currBlock
                            ) {
                                visit[nextX][nextY] = true;
                                queue.add(new int[]{nextX, nextY});
                            }
                        }
                    }

                    if (isPossible(block, board)) {
                        for (int[] b : block) board[b[0]][b[1]] = 0;

                        answer++;
                        flag = true;
                    }
                }
            }

            if (!flag) break;
        }

        return answer;
    }

    private boolean isPossible(List<int[]> block, int[][] board) {
        Set<String> blockSet = new HashSet<>();

        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

        for (int[] b : block) {
            blockSet.add(b[0] + "," + b[1]);

            minX = Math.min(minX, b[0]);
            maxX = Math.max(maxX, b[0]);
            minY = Math.min(minY, b[1]);
            maxY = Math.max(maxY, b[1]);
        }

        // blockSet에 없는 칸은 위에 아무것도 없어야 함
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (!blockSet.contains(x + "," + y)) {  // 위에 있는 칸 중 하나라도 비어있지 않으면 제거 불가
                    if (board[x][y] != 0) return false;

                    for (int k = 0; k < x; k++) {
                        if (board[k][y] != 0) return false;
                    }
                }
            }
        }

        return true;
    }
}
