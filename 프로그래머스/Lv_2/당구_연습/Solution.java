/*
 * 프로그래머스 - 당구 연습
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/169198
 */
package Lv_2.당구_연습;

import java.util.Arrays;

public class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        Arrays.fill(answer, Integer.MAX_VALUE);

        for (int i = 0; i < balls.length; i++) {
            int currX = balls[i][0];
            int currY = balls[i][1];

            if (startX != currX || startY > currY) {
                int dis = getDis(startX, startY, currX, n + (n - currY));
                answer[i] = Math.min(answer[i], dis);
            }

            if (startX != currX || startY < currY) {
                int dis = getDis(startX, startY, currX, -1 * currY);
                answer[i] = Math.min(answer[i], dis);
            }

            if (startX < currX || startY != currY) {
                int dis = getDis(startX, startY, -1 * currX, currY);
                answer[i] = Math.min(answer[i], dis);
            }

            if (startX > currX || startY != currY) {
                int dis = getDis(startX, startY, m + (m - currX), currY);
                answer[i] = Math.min(answer[i], dis);
            }
        }

        return answer;
    }

    public int getDis(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}
