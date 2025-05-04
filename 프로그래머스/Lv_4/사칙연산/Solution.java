/*
 * 프로그래머스 - 사칙연산
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1843
 */
package Lv_4.사칙연산;

class Solution {
    public static int solution(String[] arr) {
        int len = arr.length / 2 + 1;

        int[] map = new int[len];
        char[] operation = new char[len - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) map[i / 2] = Integer.parseInt(arr[i]);
            else operation[i / 2] = arr[i].charAt(0);
        }

        int[][][] dp = new int[len][len][2];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    dp[i][j][0] = map[j];
                    dp[i][j][1] = map[j];
                } else {
                    dp[i][j][0] = Integer.MIN_VALUE;
                    dp[i][j][1] = Integer.MAX_VALUE;
                }
            }
        }

        for (int size = 1; size < len; size++) {
            for (int i = 0; i < len - size; i++) {
                int end = size + i;

                for (int j = i; j < end; j++) {
                    if (operation[j] == '+') {
                        dp[i][end][0] = Math.max(dp[i][end][0], dp[i][j][0] + dp[j + 1][end][0]);
                        dp[i][end][1] = Math.min(dp[i][end][1], dp[i][j][1] + dp[j + 1][end][1]);
                    } else {
                        dp[i][end][0] = Math.max(dp[i][end][0], dp[i][j][0] - dp[j + 1][end][1]);
                        dp[i][end][1] = Math.min(dp[i][end][1], dp[i][j][1] - dp[j + 1][end][0]);
                    }
                }
            }
        }

        return dp[0][len - 1][0];
    }
}
