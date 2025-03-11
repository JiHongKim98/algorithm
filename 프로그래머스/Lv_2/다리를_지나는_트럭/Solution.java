/*
 * 프로그래머스 - 다리를 지나는 트럭
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */
package Lv_2.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();

        int tot = 0;
        int idx = 0;
        int len = truck_weights.length;

        while (idx < len || !queue.isEmpty()) {
            answer++;

            if (!queue.isEmpty() && queue.peek()[0] == answer) tot -= queue.poll()[1];

            if (idx != len && truck_weights[idx] + tot <= weight && queue.size() < bridge_length) {
                tot += truck_weights[idx];
                queue.add(new int[]{answer + bridge_length, truck_weights[idx]});
                idx++;
            }
        }

        return answer;
    }
}
