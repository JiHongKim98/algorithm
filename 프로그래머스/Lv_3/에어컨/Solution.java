/*
 * 프로그래머스 - 에어컨
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/214289
 */
package Lv_3.에어컨;

import java.util.Arrays;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int INF = 10_000_000;

        t1 += 10;
        t2 += 10;
        temperature += 10;

        int[][] dp = new int[onboard.length][51];  // 시간 | 현재 온도
        for (int i = 0; i < onboard.length; i++) Arrays.fill(dp[i], INF);

        dp[0][temperature] = 0;

        for (int i = 0; i < onboard.length - 1; i++) {
            for (int j = 0; j < 51; j++) {
                if (onboard[i] == 1 && (j < t1 || j > t2)) continue;

                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + b);  // 현재온도 == 희망온도
                if (j > 0) dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j] + a);  // 현재온도 > 희망온도
                if (j < 50) dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + a);  // 현재온도 < 희망온도

                if (j == temperature) dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                else if (j < 50 && j < temperature) dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j]);
                else if (j > temperature) dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j]);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 51; i++) {
            if (onboard[onboard.length - 1] == 1 && (i < t1 || i > t2)) continue;

            answer = Math.min(answer, dp[onboard.length - 1][i]);
        }
        return answer;
    }
}
