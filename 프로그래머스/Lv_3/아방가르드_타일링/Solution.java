/*
 * 프로그래머스 - 아방가르드 타일링
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181186
 */
package Lv_3.아방가르드_타일링;

class Solution {
    public int solution(int n) {
        long[] dp = new long[Math.max(n + 1, 5)];
        dp[0] = 1;
        dp[1] = 1;

        long[] sum = new long[3];

        for (int i = 2; i <= n; i++) {
            long a = i - 1 >= 0 ? dp[i - 1] : 0;
            long b = i - 2 >= 0 ? dp[i - 2] : 0;
            long c = i - 3 >= 0 ? dp[i - 3] : 0;
            dp[i] += a * 1 + b * 2 + c * 5;

            if (i >= 4) sum[(i - 4) % 3] = sum[(i - 4) % 3] + dp[i - 4];

            dp[i] += (sum[0] + sum[1] + sum[2] + sum[i % 3]) * 2;
            dp[i] %= 1_000_000_007;
        }

        return (int) dp[n];
    }
}
