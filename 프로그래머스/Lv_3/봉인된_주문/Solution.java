/*
 * 프로그래머스 - 봉인된 주문
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/389481
 */
package Lv_3.봉인된_주문;

import java.util.Arrays;

class Solution {
    public String solution(long n, String[] bans) {
        Arrays.sort(bans, (o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });

        String answer = convertString(n++);
        for (String ban : bans) {
            if (
                    (ban.length() < answer.length()) ||
                            (ban.length() == answer.length() && ban.compareTo(answer) <= 0)
            ) {
                answer = convertString(n++);
                continue;
            }
            return answer;
        }
        return answer;
    }

    public String convertString(long n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n--;
            sb.append((char) ('a' + (n % 26)));
            n /= 26;
        }

        return sb.reverse().toString();
    }
}
