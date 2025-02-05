/*
 * 프로그래머스 - 경주로 건설
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/67259
 */
package Lv_3.경주로_건설;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final static int[] dx = {0, 0, -1, 1};
    private final static int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        int n = board.length;
        int m = board[0].length;

        int[][][] cost = new int[n][m][4];
        for (int[][] row : cost) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, -1}); // x, y, cost, direction

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int x = poll[0];
            int y = poll[1];
            int currCost = poll[2];
            int direction = poll[3];

            if (x == n - 1 && y == m - 1) {
                answer = Math.min(answer, currCost);
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newY < 0 || newX >= n || newY >= m || board[newX][newY] == 1) continue;

                int newCost = (direction == i || direction == -1) ? currCost + 100 : currCost + 600;

                if (newCost < cost[newX][newY][i]) {
                    cost[newX][newY][i] = newCost;
                    queue.add(new int[]{newX, newY, newCost, i});
                }
            }
        }

        return answer;
    }
}

