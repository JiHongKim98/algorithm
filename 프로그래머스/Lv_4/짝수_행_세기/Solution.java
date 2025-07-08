/*
 * 프로그래머스 - 짝수 행 세기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/68647
 */
package Lv_4.짝수_행_세기;

public class Solution {
    public int solution(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int MOD = 10000019;

        long[][] nCr = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            nCr[i][0] = nCr[i][i] = 1;
            for (int j = 1; j < i; j++) {
                nCr[i][j] = (nCr[i - 1][j - 1] + nCr[i - 1][j]) % MOD;
            }
        }

        int[] colMap = new int[m];
        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n; row++) {
                if (a[row][col] == 1) colMap[col]++;
            }
        }

        long[][] dp = new long[n + 1][m];
        dp[colMap[0]][0] = nCr[n][colMap[0]];

        for (int col = 0; col < m - 1; col++) {
            for (int row = 0; row <= n; row++) {
                if (dp[row][col] == 0) continue;

                int maxOddCount = Math.min(row, colMap[col + 1]);  // 현재 홀수행
                for (int oddCount = 0; oddCount <= maxOddCount; oddCount++) {
                    int evenCount = colMap[col + 1] - oddCount;  // 짝수행에 1 할당

                    int remainEvenCount = n - row - evenCount;
                    if (remainEvenCount >= 0) {
                        int nextOddCount = row - oddCount + evenCount;

                        long count = dp[row][col];
                        count = (count * nCr[row][oddCount]) % MOD;
                        count = (count * nCr[n - row][evenCount]) % MOD;
                        dp[nextOddCount][col + 1] = (dp[nextOddCount][col + 1] + count) % MOD;
                    }
                }
            }
        }
        return (int) (dp[0][m - 1] % MOD);
    }
}
