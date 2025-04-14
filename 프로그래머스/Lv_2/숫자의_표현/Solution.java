/*
 * 프로그래머스 - 숫자의 표현
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12924
 */
package Lv_2.숫자의_표현;

class Solution {
    public int solution(int n) {
        int answer = 1;

        for (int i = 1; i <= (n / 2); i++) {
            int curr = i;

            loop:
            for (int j = i + 1; j <= (n / 2) + 1; j++) {
                curr += j;

                if (curr == n) answer++;
                if (curr >= n) break loop;
            }
        }

        return answer;
    }
}
