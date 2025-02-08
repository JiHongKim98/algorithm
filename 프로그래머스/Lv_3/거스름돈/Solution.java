/*
 * 프로그래머스 - 거스름돈
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12907
 */
package Lv_3.거스름돈;

class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int currMoney : money) {
            for (int i = currMoney; i < dp.length; i++) {
                dp[i] += dp[i - currMoney] % 1_000_000_007;  // 현재 화폐 제외하고 이전에 냈던 경우의 수 누적
            }
        }

        return dp[n];
    }
}
