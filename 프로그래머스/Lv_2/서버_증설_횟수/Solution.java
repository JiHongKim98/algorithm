/*
 * 프로그래머스 - 서버 증설 횟수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/389479
 */
package Lv_2.서버_증설_횟수;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 24; i++) {
            while (!queue.isEmpty() && queue.peek() <= i) {
                queue.poll();
            }

            int requireServer = players[i] / m;
            int currServer = queue.size();

            if (requireServer > currServer) {
                int addServer = requireServer - currServer;
                answer += addServer;

                for (int j = 0; j < addServer; j++) {
                    queue.add(i + k);
                }
            }
        }

        return answer;
    }
}
