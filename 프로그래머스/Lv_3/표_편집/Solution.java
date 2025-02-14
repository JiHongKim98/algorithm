/*
 * 프로그래머스 - 표 편집
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/81303
 */
package Lv_3.표_편집;

import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> lastRemove = new Stack<>();

        for (String c : cmd) {
            char command = c.charAt(0);

            if (command == 'U') {
                k -= Integer.parseInt(c.substring(2));
            } else if (command == 'D') {
                k += Integer.parseInt(c.substring(2));
            } else if (command == 'C') {
                lastRemove.add(k);
                n--;
                if (k == n) k--;  // 삭제 행이 마지막 행인 경우
            } else if (command == 'Z') {
                if (lastRemove.pop() <= k) k++;  // 현재 선택행 유지
                n++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("O");
        }

        while (!lastRemove.isEmpty()) {
            sb.insert(lastRemove.pop(), "X");
        }

        return sb.toString();
    }
}
