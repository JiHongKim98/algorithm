/*
 * 프로그래머스 - 완전범죄
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/389480
 */
package Lv_2.완전범죄;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[m];

        for (int i = 0; i < m; i++) {
            for (int[] curr : info) {
                dp[i] += curr[0];

                if (i + curr[1] < m) dp[i] = Math.min(dp[i], dp[i + curr[1]]);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (dp[i] < n) answer = Math.min(answer, dp[i]);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
