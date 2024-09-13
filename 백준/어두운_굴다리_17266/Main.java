package 어두운_굴다리_17266;
/* 백준(이분 탐색) - 어두운 굴다리
 *
 * https://www.acmicpc.net/problem/17266
 */

import java.util.Scanner;

public class Main {

	private static int 굴다리_길이;
	private static int 가로등_개수;

	private static int[] map;

	public static void main(String[] args) {
		int answer = 0;

		Scanner scanner = new Scanner(System.in);
		굴다리_길이 = scanner.nextInt();
		가로등_개수 = scanner.nextInt();

		map = new int[가로등_개수];

		for (int i = 0; i < 가로등_개수; i++) {
			map[i] = scanner.nextInt();
		}

		int start = 1;
		int max = 굴다리_길이;

		while (start <= max) {
			int half = (start + max) / 2;

			if (check(half)) {
				answer = half;
				max = half - 1;
			} else {
				start = half + 1;
			}
		}

		System.out.println(answer);
	}

	static boolean check(int target) {
		int before = 0;

		for (int i = 0; i < map.length; i++) {
			if (map[i] - target <= before) {
				before = map[i] + target;
				continue;
			}
			return false;
		}

		return 굴다리_길이 - before <= 0;
	}
}
