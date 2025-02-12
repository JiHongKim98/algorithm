/*
 * 프로그래머스 - 올바른 괄호
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
package Lv_2.올바른_괄호;

/**
 * @see Lv_2.올바른_괄호.SolutionStack 스택 풀이
 */
class Solution {
    boolean solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                count--;
            } else {
                count++;
            }

            if (count < 0) {
                return false;
            }
        }

        if (count != 0) {
            return false;
        }
        return true;
    }
}
