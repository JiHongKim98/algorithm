/*
 * 프로그래머스 - GPS
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1837
 */
package Lv_3.GPS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private final int INF = 999_999_999;

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edge_list) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[][] dp = new int[k][n + 1];

        for (int i = 0; i < k; i++) Arrays.fill(dp[i], INF);
        dp[0][gps_log[0]] = 0;

        for (int i = 1; i < k; i++) {  // GPS log
            for (int j = 1; j <= n; j++) {  // NODE 수
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);

                for (int node : graph.get(j)) dp[i][j] = Math.min(dp[i][j], dp[i - 1][node]);

                if (gps_log[i] != j) dp[i][j] += 1;
            }
        }

        if (dp[k - 1][gps_log[k - 1]] >= INF) return -1;
        return dp[k - 1][gps_log[k - 1]];
    }
}
