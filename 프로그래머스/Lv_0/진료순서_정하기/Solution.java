/*
 * 프로그래머스 - 진료순서 정하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120835
 */
package Lv_0.진료순서_정하기;

import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[] emergency) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> emergency[o1] - emergency[o2]);

        int len = emergency.length;
        for (int i = 0; i < len; i++) pq.add(i);

        int[] answer = new int[len];
        for (int i = 0; i < len; i++) answer[i] = len - pq.poll();

        return answer;
    }
}
