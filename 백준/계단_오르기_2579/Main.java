package 계단_오르기_2579;
/* 백준(DP) - 계단 오르기
 *
 * https://www.acmicpc.net/problem/2579
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int 전체_개수 = sc.nextInt();

		int[] map = new int[전체_개수 + 1];
		long[] 동적프로그래뮝 = new long[전체_개수 + 1];

		for (int i = 1; i <= 전체_개수; i++) {
			map[i] = sc.nextInt();
		}

		동적프로그래뮝[0] = 0;
		동적프로그래뮝[1] = map[1];

		if (전체_개수 >= 2) {
			동적프로그래뮝[2] = map[2] + map[1];
		}

		for (int i = 3; i <= 전체_개수; i++) {
			동적프로그래뮝[i] = Math.max(map[i - 1] + 동적프로그래뮝[i - 3], 동적프로그래뮝[i - 2]) + map[i];
		}

		System.out.println(동적프로그래뮝[전체_개수]);
	}
}
