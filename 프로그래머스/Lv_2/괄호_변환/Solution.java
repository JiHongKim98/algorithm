/*
 * 프로그래머스 - 괄호 변환
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/60058
 */
package Lv_2.괄호_변환;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        return dfs(p);
    }

    private String dfs(String p) {
        if (p.equals("")) return "";

        String[] split = splitUV(p);
        String u = split[0];
        String v = split[1];

        if (isPossible(u)) {
            return u + dfs(v);
        }

        // u 가 "올바른 괄호 문자열"이 아닌 경우 -> v 에 대해 재귀 진행
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(dfs(v)).append(")");

        // 첫번째 마지막 제거
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }

        return sb.toString();
    }

    private boolean isPossible(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else if (stack.isEmpty()) return false;
            else stack.pop();
        }
        return stack.isEmpty();
    }

    // { u, v }
    private String[] splitUV(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count++;
            else count--;

            if (count == 0) {
                return new String[]{p.substring(0, i + 1), p.substring(i + 1)};
            }
        }
        return new String[]{"", ""};  // "올바른 괄호 문자열" 변환 불가
    }
}
