/*
 * 프로그래머스 - 코딩 테스트 공부
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/118668
 */
package Lv_3.코딩_테스트_공부;

import java.util.Arrays;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;
        for (int[] prob : problems) {
            maxAlp = Math.max(maxAlp, prob[0]);
            maxCop = Math.max(maxCop, prob[1]);
        }

        int[][] dp = new int[maxAlp + 31][maxCop + 31];
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);

        // 시작 위치 보정
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        dp[alp][cop] = 0;

        for (int i = alp; i <= maxAlp + 1; i++) {
            for (int j = cop; j <= maxCop + 1; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                for (int[] prob : problems) {
                    if (i >= prob[0] && j >= prob[1]) {
                        int nextAlp = Math.min(i + prob[2], maxAlp + 1);
                        int nextCop = Math.min(j + prob[3], maxCop + 1);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + prob[4]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = maxAlp; i <= maxAlp + 30; i++) {
            for (int j = maxCop; j <= maxCop + 30; j++) {
                answer = Math.min(answer, dp[i][j]);
            }
        }

        return answer;
    }
}
