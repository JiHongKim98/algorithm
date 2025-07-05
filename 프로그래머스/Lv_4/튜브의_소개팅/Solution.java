/*
 * 프로그래머스 - 튜브의 소개팅
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1839
 */
package Lv_4.튜브의_소개팅;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};

    public int[] solution(int m, int n, int s, int[][] time_map) {
        long[][] timeMap = new long[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(timeMap[i], Integer.MAX_VALUE);
        timeMap[0][0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currX = poll[0];
            int currY = poll[1];
            int currMove = poll[2];

            if (currX == m - 1 && currY == n - 1 && timeMap[currX][currY] <= s) {
                return new int[]{currMove, (int) timeMap[currX][currY]};
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (time_map[nextX][nextY] == -1) continue;

                    long nextTime = timeMap[currX][currY] + time_map[nextX][nextY];
                    if (timeMap[nextX][nextY] > nextTime) {
                        timeMap[nextX][nextY] = nextTime;
                        queue.add(new int[]{nextX, nextY, currMove + 1});
                    }
                }
            }
        }

        return new int[]{-1};
    }
}
