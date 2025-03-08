/*
 * 프로그래머스 - 뒤에 있는 큰 수 찾기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */
package Lv_2.뒤에_있는_큰_수_찾기;

import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            int curr = numbers[i];

            while (!stack.isEmpty() && stack.peek() <= curr) stack.pop();

            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(curr);
        }
        return answer;
    }
}
