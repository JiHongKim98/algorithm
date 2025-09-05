/*
 * 프로그래머스 - 코드 처리하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181932
 */
package Lv_0.코드_처리하기;

class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();

        int mem = 0;
        for (int i = 0; i < code.length(); i++) {
            char curr = code.charAt(i);

            if (curr == '1') mem = mem == 0 ? 1 : 0;
            else if (i % 2 == mem) sb.append(curr);
        }

        String answer = sb.toString();
        return answer.length() != 0 ? answer : "EMPTY";
    }
}
