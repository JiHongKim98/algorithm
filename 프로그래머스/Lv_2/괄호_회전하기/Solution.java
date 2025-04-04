/*
 * 프로그래머스 - 괄호 회전하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */
package Lv_2.괄호_회전하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) queue.add(s.charAt(i));

        int rotateCount = 0;

        while (rotateCount != s.length()) {
            Stack<Character> stack = new Stack<>();

            boolean flag = true;

            queueLoop:
            for (char q : queue) {
                if (q == '[' || q == '(' || q == '{') {
                    stack.push(q);
                } else {
                    if (
                            !stack.isEmpty() && (
                                    (stack.peek() == '[' && q == ']') ||
                                            (stack.peek() == '{' && q == '}') ||
                                            (stack.peek() == '(' && q == ')')
                            )
                    ) {
                        stack.pop();
                    } else {
                        flag = false;
                        break queueLoop;
                    }
                }
            }

            if (stack.isEmpty() && flag) answer++;

            rotateCount++;
            queue.add(queue.poll());
        }

        return answer;
    }
}
