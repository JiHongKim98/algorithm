/*
 * 프로그래머스 - 이상한 문자 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12930
 */
package Lv_1.이상한_문자_만들기;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == ' ') {
                sb.append(' ');
                idx = 0;
            } else if (idx++ % 2 == 0) {
                sb.append(Character.toUpperCase(curr));
            } else {
                sb.append(Character.toLowerCase(curr));
            }
        }

        return sb.toString();
    }
}
