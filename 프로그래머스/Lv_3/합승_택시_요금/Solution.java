/*
 * 프로그래머스 - 합승 택시 요금
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/72413
 */
package Lv_3.합승_택시_요금;

import java.util.Arrays;

class Solution {

    private static final int INF = 100_000 * 200 + 1;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] costMap = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(costMap[i], INF);
            costMap[i][i] = 0;
        }

        for (int[] fare : fares) {
            costMap[fare[0]][fare[1]] = fare[2];
            costMap[fare[1]][fare[0]] = fare[2];
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (costMap[i][k] != INF && costMap[k][j] != INF) {
                        costMap[i][j] = Math.min(costMap[i][j], costMap[i][k] + costMap[k][j]);
                    }
                }
            }
        }

        int answer = costMap[s][a] + costMap[s][b];  // 합승하지 않은 경우
        for (int i = 1; i < n + 1; i++) {
            answer = Math.min(answer, costMap[s][i] + costMap[i][a] + costMap[i][b]);  // 합승하는 경우
        }
        return answer;
    }
}
