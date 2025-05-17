/*
 * 프로그래머스 - 수식 최대화
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/67257
 */
package Lv_2.수식_최대화;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private char[] oper = {'+', '-', '*'};

    private List<Long> numMap;
    private List<Character> operMap;

    private long answer = 0;

    public long solution(String expression) {
        numMap = new ArrayList<>();
        operMap = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                numMap.add(Long.parseLong(expression.substring(idx, i)));
                operMap.add(c);
                idx = i + 1;
            }
        }
        numMap.add(Long.parseLong(expression.substring(idx, expression.length())));

        DFS("", 0, new boolean[3]);

        return answer;
    }

    private void DFS(String opers, int depth, boolean[] visit) {
        if (depth == 3) {
            cal(opers);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visit[i]) continue;
            else visit[i] = true;

            DFS(opers + oper[i], depth + 1, visit);

            visit[i] = false;
        }
    }

    private void cal(String opers) {
        List<Long> nums = new ArrayList<>(numMap);
        List<Character> ops = new ArrayList<>(operMap);

        for (char op : opers.toCharArray()) {
            for (int i = 0; i < ops.size(); ) {
                if (ops.get(i) == op) {
                    long result = 0;

                    long a = nums.get(i);
                    long b = nums.get(i + 1);

                    switch (op) {
                        case '+':
                            result = a + b;
                            break;
                        case '-':
                            result = a - b;
                            break;
                        case '*':
                            result = a * b;
                            break;
                    }

                    ops.remove(i);

                    nums.set(i, result);
                    nums.remove(i + 1);
                } else {
                    i++;
                }
            }
        }

        answer = Math.max(answer, Math.abs(nums.get(0)));
    }
}
