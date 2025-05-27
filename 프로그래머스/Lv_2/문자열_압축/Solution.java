/*
 * 프로그래머스 - 문자열 압축
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */
package Lv_2.문자열_압축;

class Solution {
    public int solution(String s) {
        int max = s.length();
        int answer = max;

        for (int i = 1; i <= max / 2; i++) {
            int len = 0;
            int count = 1;

            String curr = "";

            for (int j = 0; j <= max; j += i) {
                String next = s.substring(j, Math.min(max, j + i));

                if (curr.equals(next)) {
                    count++;
                } else {
                    if (count > 1) len += String.valueOf(count).length();
                    len += next.length();
                    curr = next;
                    count = 1;
                }
            }

            answer = Math.min(answer, len);
        }

        return answer;
    }
}
