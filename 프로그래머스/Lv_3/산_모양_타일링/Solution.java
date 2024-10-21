/*
 * 프로그래머스 - 산 모양 타일링
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/258705
 */
package Lv_3.산_모양_타일링;

class Solution {

	public int solution(int n, int[] tops) {
		int[][] dp = new int[n + 1][2];
		dp[0][0] = 1;
		dp[0][1] = 2 + tops[0];

		for (int i = 1; i < n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 10007;
			dp[i][1] = (
				(dp[i - 1][0] * (tops[i] + 1))
					+ (dp[i - 1][1] * (tops[i] + 2))
			) % 10007;
		}

		return (dp[n - 1][0] + dp[n - 1][1]) % 10007;
	}
}
