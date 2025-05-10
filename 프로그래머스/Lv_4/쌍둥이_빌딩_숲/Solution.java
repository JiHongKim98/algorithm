/*
 * 프로그래머스 - 쌍둥이 빌딩 숲
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/140105
 */
package Lv_4.쌍둥이_빌딩_숲;

class Solution {
    public int solution(int n, int count) {
        long[][] dp = new long[n + 1][count + 1];

        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= count; j++) {
                long a = dp[i - 1][j - 1];  // 제일 앞에 배치
                long b = dp[i - 1][j] * (i - 1) * 2;  // 제일 앞을 제외하고 배치

                dp[i][j] = (a + b) % 1_000_000_007;
            }
        }

        return (int) dp[n][count];
    }
}
