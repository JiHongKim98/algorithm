package 설탕_배달_2839;
/*
 * 백준(그리디) - 설탕 배달
 *
 * https://www.acmicpc.net/problem/2839
 */

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		int answer = Integer.MAX_VALUE;
		Scanner sc = new Scanner(System.in);

		int target = sc.nextInt();

		int max_5 = target / 5;

		while (true) {
			int t = target;
			t = t - max_5 * 5;
			int now = max_5;

			int 세개 = t / 3;
			t = t - (세개 * 3);
			now = 세개 + now;

			if (t == 0) {
				answer = Math.min(now, answer);
			}

			if (max_5 == 0) {
				break;
			}

			max_5--;
		}

		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}

		System.out.println(answer);
	}
}
