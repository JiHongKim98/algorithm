/*
 * 프로그래머스 - 매출 하락 최소화
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/72416
 */
package Lv_4.매출_하락_최소화;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int[][] dp;
    private List<List<Integer>> map = new ArrayList<>();

    public int solution(int[] sales, int[][] links) {
        dp = new int[sales.length][2];

        for (int i = 0; i < sales.length; i++) {
            map.add(new ArrayList<>());
            dp[i][0] = sales[i];
        }
        for (int[] link : links) map.get(link[0] - 1).add(link[1] - 1);

        DFS(0);

        return Math.min(dp[0][0], dp[0][1]);
    }

    private void DFS(int node) {
        int minDiff = Integer.MAX_VALUE;

        for (int nextNode : map.get(node)) {
            DFS(nextNode);

            if (dp[nextNode][0] < dp[nextNode][1]) {
                dp[node][0] += dp[nextNode][0];
                dp[node][1] += dp[nextNode][0];

                minDiff = 0;
            } else {
                dp[node][0] += dp[nextNode][1];
                dp[node][1] += dp[nextNode][1];

                minDiff = Math.min(minDiff, dp[nextNode][0] - dp[nextNode][1]);
            }
        }

        if (minDiff != Integer.MAX_VALUE) dp[node][1] += minDiff;
    }
}
