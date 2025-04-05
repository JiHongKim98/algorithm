/*
 * 프로그래머스 - 최적의 행렬 곱셈
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12942
 */
package Lv_3.최적의_행렬_곱셈;

class Solution {

    private int[][] dp;
    private int[][] matrix_sizes;

    public int solution(int[][] matrix_sizes) {
        dp = new int[matrix_sizes.length][matrix_sizes.length];
        this.matrix_sizes = matrix_sizes;

        for (int i = 0; i < matrix_sizes.length; i++) {
            for (int j = 0; j < matrix_sizes.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        return div(0, matrix_sizes.length - 1);
    }

    public int div(int start, int end) {
        if (start == end) return 0;
        if (dp[start][end] != Integer.MAX_VALUE) return dp[start][end];

        for (int i = start; i < end; i++) {
            int curr = 0;
            curr += div(start, i) + div(i + 1, end);
            curr += (matrix_sizes[start][0] * matrix_sizes[i][1] * matrix_sizes[end][1]);
            dp[start][end] = Math.min(dp[start][end], curr);
        }
        return dp[start][end];
    }
}
