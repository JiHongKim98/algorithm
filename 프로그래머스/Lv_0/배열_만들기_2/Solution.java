/*
 * 프로그래머스 - 배열 만들기 2
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181921
 */
package Lv_0.배열_만들기_2;

import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num > r) continue;
            if (num >= l) answer.add(num);

            queue.add(num * 10);
            queue.add(num * 10 + 5);
        }

        if (answer.isEmpty()) return new int[]{-1};

        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
