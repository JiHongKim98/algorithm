/*
 * 프로그래머스 - 리코쳇 로봇
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/169199
 */
package Lv_2.리코쳇_로봇;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};

    public int solution(String[] board) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[board.length][board[0].length()];

        loop:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    queue.add(new int[]{i, j, 0});
                    break loop;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (board[poll[0]].charAt(poll[1]) == 'G') return poll[2];

            if (visit[poll[0]][poll[1]]) continue;
            else visit[poll[0]][poll[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = poll[0];
                int nextY = poll[1];

                while (true) {
                    if (
                            nextX < 0 || nextX >= board.length ||
                                    nextY < 0 || nextY >= board[0].length() ||
                                    board[nextX].charAt(nextY) == 'D'
                    ) {
                        nextX -= dx[i];
                        nextY -= dy[i];
                        break;
                    }

                    nextX += dx[i];
                    nextY += dy[i];
                }

                if (!visit[nextX][nextY]) queue.add(new int[]{nextX, nextY, poll[2] + 1});
            }
        }

        return -1;
    }
}
