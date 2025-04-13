/*
 * 프로그래머스 - 짝지어 제거하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */
package Lv_2.짝지어_제거하기;

import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == curr) stack.pop();
            else stack.push(curr);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
