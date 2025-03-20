/*
 * 프로그래머스 - 카운트 다운
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131129
 */
package Lv_3.카운트_다운;

class Solution {
    public int[] solution(int target) {
        int[][] dp = new int[target + 1][2];

        for (int i = 1; i <= target; i++) dp[i][0] = Integer.MAX_VALUE;

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i >= 50) { // 50점
                    if (dp[i][0] > dp[i - 50][0] + 1) {
                        dp[i][0] = dp[i - 50][0] + 1;
                        dp[i][1] = dp[i - 50][1] + 1;
                    } else if (dp[i][0] == dp[i - 50][0] + 1) {
                        dp[i][1] = Math.max(dp[i][1], dp[i - 50][1] + 1);
                    }
                }

                if (i >= j) { // 1점
                    if (dp[i][0] > dp[i - j][0] + 1) {
                        dp[i][0] = dp[i - j][0] + 1;
                        dp[i][1] = dp[i - j][1] + 1;
                    } else if (dp[i][0] == dp[i - j][0] + 1) {
                        dp[i][1] = Math.max(dp[i][1], dp[i - j][1] + 1);
                    }
                }

                if (i >= j * 2) { // 2점
                    if (dp[i][0] > dp[i - j * 2][0] + 1) {
                        dp[i][0] = dp[i - j * 2][0] + 1;
                        dp[i][1] = dp[i - j * 2][1];
                    }
                }

                if (i >= j * 3) {  // 3점
                    if (dp[i][0] > dp[i - j * 3][0] + 1) {
                        dp[i][0] = dp[i - j * 3][0] + 1;
                        dp[i][1] = dp[i - j * 3][1];
                    }
                }
            }
        }

        return dp[target];
    }
}
