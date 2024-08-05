package dp.타일01_1904;
/* 백준(dp) - 타일 01
 *
 * https://www.acmicpc.net/problem/1904
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int 자릿수 = sc.nextInt();

		long[] map = new long[1_000_001];
		map[0] = 0;
		map[1] = 1;
		map[2] = 2;

		if (자릿수 < 3) {
			System.out.println(map[자릿수]);
			return;
		}

		for (int i = 3; i < 자릿수 + 1; i++) {
			map[i] = (map[i - 1] + map[i - 2]) % 15746;
		}

		System.out.println(map[자릿수]);
	}
}
