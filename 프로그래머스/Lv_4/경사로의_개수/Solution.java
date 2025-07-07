/*
 * 프로그래머스 - 경사로의 개수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/214290
 */
package Lv_4.경사로의_개수;

class Solution {

    private int MOD = 1_000_000_007;
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] grid, int[] d, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int maxLen = n * m;
        long[][] dp = new long[maxLen][maxLen];  // (x,y) 좌표를 1차원 배열로 변환 (4차원 -> 2차원)

        for (int i = 0; i < maxLen; i++) dp[i][i] = 1;

        for (int currD : d) {
            long[][] nextDp = new long[maxLen][maxLen];

            for (int i = 0; i < maxLen; i++) {
                for (int j = 0; j < maxLen; j++) {
                    int currX = j / m;
                    int currY = j % m;

                    if (dp[i][j] == 0) continue;

                    for (int l = 0; l < 4; l++) {
                        int nextX = currX + dx[l];
                        int nextY = currY + dy[l];

                        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;

                        if (grid[nextX][nextY] - grid[currX][currY] == currD) {
                            int nextIdx = nextX * m + nextY;
                            nextDp[i][nextIdx] = (nextDp[i][nextIdx] + dp[i][j]) % MOD;
                        }
                    }
                }
            }
            dp = nextDp;
        }

        long[][] result = matrixPower(dp, k);

        long answer = 0;
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < maxLen; j++) {
                answer = (answer + result[i][j]) % MOD;
            }
        }
        return (int) answer;
    }

    private long[][] matrixPower(long[][] matrix, int power) {
        int len = matrix.length;
        long[][] result = new long[len][len];

        for (int i = 0; i < len; i++) result[i][i] = 1;

        while (power > 0) {
            if ((power & 1) == 1) result = multiply(result, matrix);

            matrix = multiply(matrix, matrix);
            power >>= 1;
        }
        return result;
    }

    private long[][] multiply(long[][] matrixA, long[][] matrixB) {
        int len = matrixA.length;
        long[][] result = new long[len][len];

        for (int i = 0; i < len; i++) {
            for (int k = 0; k < len; k++) {
                if (matrixA[i][k] == 0) continue;

                for (int j = 0; j < len; j++) {
                    if (matrixB[k][j] == 0) continue;

                    result[i][j] = (result[i][j] + matrixA[i][k] * matrixB[k][j]) % MOD;
                }
            }
        }
        return result;
    }
}
