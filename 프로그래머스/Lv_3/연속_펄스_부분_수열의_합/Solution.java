/*
 * 프로그래머스 - 연속 펄스 부분 수열의 합
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/161988
 */
package Lv_3.연속_펄스_부분_수열의_합;

class Solution {
    public long solution(int[] sequence) {
        if (sequence.length == 1) return Math.max(sequence[0], sequence[0] * -1);

        long answer = 0;

        long[][] dp = new long[sequence.length][2];
        dp[0][0] = sequence[0];
        dp[0][1] = sequence[0] * -1;

        for (int i = 1; i < sequence.length; i++) {
            int d = i % 2 == 0 ? 1 : -1;

            dp[i][0] = Math.max(dp[i - 1][0], 0) + (sequence[i] * d);
            dp[i][1] = Math.max(dp[i - 1][1], 0) - (sequence[i] * d);

            answer = Math.max(dp[i][0], answer);
            answer = Math.max(dp[i][1], answer);
        }

        return answer;
    }
}
