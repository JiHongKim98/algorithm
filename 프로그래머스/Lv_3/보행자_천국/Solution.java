/*
 * 프로그래머스 - 보행자 천국
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1832
 */
package Lv_3.보행자_천국;

class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][] dp1 = new int[m][n];
        int[][] dp2 = new int[m][n];

        dp1[0][0] = dp2[0][0] = 1;

        for (int i = 1; i < n; i++) {
            if (cityMap[0][i] == 1) break;
            dp1[0][i] = dp1[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            if (cityMap[i][0] == 1) break;
            dp2[i][0] = dp2[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) continue;

                if (cityMap[i][j - 1] != 2) dp1[i][j] = (dp1[i][j - 1] + dp2[i][j - 1]) % MOD;
                else dp1[i][j] = dp1[i][j - 1];

                if (cityMap[i - 1][j] != 2) dp2[i][j] = (dp1[i - 1][j] + dp2[i - 1][j]) % MOD;
                else dp2[i][j] = dp2[i - 1][j];
            }
        }

        return (dp1[m - 1][n - 1] + dp2[m - 1][n - 1]) % MOD;
    }
}
