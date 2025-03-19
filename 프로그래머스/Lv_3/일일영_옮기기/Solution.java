/*
 * 프로그래머스 - 110 옮기기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/77886
 */
package Lv_3.일일영_옮기기;

import java.util.Stack;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            String str = s[i];

            int count = 0;
            Stack<Character> stack = new Stack<>();

            for (char c : str.toCharArray()) {
                stack.push(c);

                if (stack.size() >= 3) {
                    char pop3 = stack.pop();
                    char pop2 = stack.pop();
                    char pop1 = stack.pop();

                    if (pop1 == '1' && pop2 == '1' && pop3 == '0') {
                        count++;
                    } else {
                        stack.push(pop1);
                        stack.push(pop2);
                        stack.push(pop3);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) sb.append(stack.pop());

            sb.reverse();
            int lastZeroIdx = sb.lastIndexOf("0");
            sb.insert(lastZeroIdx + 1, "110".repeat(count));

            answer[i] = sb.toString();
        }

        return answer;
    }
}
