/*
 * 프로그래머스 - 멀리 뛰기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */
package Lv_2.멀리_뛰기;

class Solution {
    public long solution(int n) {
        int[] dp = new int[n + 1];

        int STUP = 1234567;
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % STUP;
        }

        return dp[n];
    }
}
