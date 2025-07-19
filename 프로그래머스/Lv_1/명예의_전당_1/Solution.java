/*
 * 프로그래머스 - 명예의 전당 (1)
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/138477
 */
package Lv_1.명예의_전당_1;

import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);

            if (queue.size() > k) queue.poll();

            answer[i] = queue.peek();
        }
        return answer;
    }
}
