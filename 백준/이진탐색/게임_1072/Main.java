package 이진탐색.게임_1072;
/* 백준(이진탐색) - 풍선 공장
 *
 * https://www.acmicpc.net/problem/1072
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalGame = sc.nextInt();
		int winCount = sc.nextInt();

		int 확률 = getPercent(totalGame, winCount);

		int answer = -1;
		int min = 0;
		int max = (int)1e9;

		while (min <= max) {
			int mid = (min + max) / 2;

			if (getPercent(totalGame + mid, winCount + mid) != 확률) {
				answer = mid;
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(answer);
	}

	private static int getPercent(int x, int y) {
		return (int)((long)y * 100 / x);
	}
}
