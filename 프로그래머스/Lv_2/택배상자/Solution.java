/*
 * 프로그래머스 - 택배상자
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 */
package Lv_2.택배상자;

import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();  // 임시 컨테이너 벨트

        int idx = 1;  // 기존 컨테이너 벨트
        for (int o : order) {
            while (o > idx) stack.push(idx++);

            if (idx == o) idx++;
            else if (!stack.isEmpty() && stack.peek() == o) stack.pop();
            else break;

            answer++;
        }

        return answer;
    }
}
