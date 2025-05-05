/*
 * 프로그래머스 - 지형 이동
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/62050
 */
package Lv_4.지형_이동;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] land, int height) {
        int answer = 0;

        boolean[][] visit = new boolean[land.length][land.length];

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        queue.add(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int x = poll[0];
            int y = poll[1];

            if (visit[x][y]) continue;

            answer += poll[2];
            visit[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (
                        moveX < land.length && moveX >= 0 &&
                                moveY < land.length && moveY >= 0
                ) {
                    int moveCost = Math.abs(land[x][y] - land[moveX][moveY]);

                    if (moveCost > height) queue.add(new int[]{moveX, moveY, moveCost});
                    else queue.add(new int[]{moveX, moveY, 0});
                }
            }
        }

        return answer;
    }
}
