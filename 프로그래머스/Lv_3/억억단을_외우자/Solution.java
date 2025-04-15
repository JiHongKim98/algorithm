/*
 * 프로그래머스 - 억억단을 외우자
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/138475
 */
package Lv_3.억억단을_외우자;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] map = new int[e + 1];

        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) map[j]++;
        }

        int[][] dp = new int[e + 1][2];
        dp[e][0] = e;
        dp[e][1] = map[e];

        for (int i = e - 1; i > 0; i--) {
            if (dp[i + 1][1] <= map[i]) {
                dp[i][0] = i;
                dp[i][1] = map[i];
            } else {
                dp[i][0] = dp[i + 1][0];
                dp[i][1] = dp[i + 1][1];
            }
        }

        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = dp[starts[i]][0];
        }

        return answer;
    }
}
