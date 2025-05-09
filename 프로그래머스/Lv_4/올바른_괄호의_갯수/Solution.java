/*
 * 프로그래머스 - 올바른 괄호의 갯수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12929
 */
package Lv_4.올바른_괄호의_갯수;

class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
}
