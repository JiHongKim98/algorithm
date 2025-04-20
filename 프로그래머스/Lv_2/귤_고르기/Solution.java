/*
 * 프로그래머스 - 귤 고르기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */
package Lv_2.귤_고르기;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(map.values());

        int answer = 0;
        while (k > 0 && !queue.isEmpty()) {
            k -= queue.poll();
            answer++;
        }

        return answer;
    }
}
