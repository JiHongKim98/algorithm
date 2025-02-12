/*
 * 프로그래머스 - 올바른 괄호 (스택풀이)
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
package Lv_2.올바른_괄호;

import java.util.Stack;

/**
 * @see Lv_2.올바른_괄호.Solution 스택 안쓴 풀이
 */
class SolutionStack {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(1);
                continue;
            }

            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
