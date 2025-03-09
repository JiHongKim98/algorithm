/*
 * 프로그래머스 - 프로세스
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */
package Lv_2.프로세스;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        Arrays.sort(priorities);

        for (int i = priorities.length - 1; i >= 0; i--) {
            answer++;

            while (!queue.isEmpty() && priorities[i] != queue.peek()[1]) queue.add(queue.poll());

            if (queue.poll()[0] == location) return answer;
        }
        return -1;
    }
}
