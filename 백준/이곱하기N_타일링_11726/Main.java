/*
 * 백준 - 2×n 타일링
 *
 * https://www.acmicpc.net/problem/11726
 */
package 이곱하기N_타일링_11726;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int max = sc.nextInt();
		int[] DP = new int[1001];

		DP[0] = 0;
		DP[1] = 1;
		DP[2] = 2;

		for (int i = 3; i <= max; i++) {
			DP[i] = (DP[i - 1] + DP[i - 2]) % 10007;
		}

		System.out.println(DP[max]);
	}
}
