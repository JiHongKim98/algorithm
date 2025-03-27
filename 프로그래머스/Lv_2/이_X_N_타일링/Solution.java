/*
 * 프로그래머스 - 2 x n 타일링
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12900
 */
package Lv_2.이_X_N_타일링;

class Solution {
    public int solution(int n) {
        int[] dp = new int[60_001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007;
        }

        return dp[n];
    }
}
