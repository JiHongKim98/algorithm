/*
 * 프로그래머스 - 이중우선순위큐
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 */
package Lv_3.이중우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for (String operation : operations) {
            String[] split = operation.split(" ");

            int num = Integer.parseInt(split[1]);

            if (split[0].equals("I")) {
                maxQueue.add(num);
                minQueue.add(num);
                continue;
            }

            if (maxQueue.isEmpty() || minQueue.isEmpty()) continue;

            if (num == -1) {
                int min = minQueue.poll();
                maxQueue.remove(min);
            } else {
                int max = maxQueue.poll();
                minQueue.remove(max);
            }
        }

        if (maxQueue.isEmpty() || minQueue.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxQueue.poll(), minQueue.poll()};
        }
    }
}
