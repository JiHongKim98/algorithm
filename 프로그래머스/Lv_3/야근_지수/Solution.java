/*
 * 프로그래머스 - 야근 지수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12927
 */
package Lv_3.야근_지수;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) queue.add(work);

        while (n > 0) {
            int current = queue.poll();

            if (current == 0) break;

            queue.add(current - 1);
            n--;
        }

        while (!queue.isEmpty()) {
            answer += Math.pow(queue.poll(), 2);
        }

        return answer;
    }
}
