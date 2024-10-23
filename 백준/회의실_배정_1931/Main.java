/*
 * 백준 - 회의실 배정
 *
 * https://www.acmicpc.net/problem/1931
 */
package 회의실_배정_1931;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int max = scanner.nextInt();

		int[][] map = new int[max][2];

		for (int i = 0; i < max; i++) {
			map[i][0] = scanner.nextInt();
			map[i][1] = scanner.nextInt();
		}

		// 끝나는 시간 기점으로 정렬
		Arrays.sort(map, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});

		int answer = 0;
		int endTime = 0;
		for (int i = 0; i < max; i++) {
			int nowStartTime = map[i][0];
			int nowEndTime = map[i][1];

			if (endTime <= nowStartTime) {
				endTime = nowEndTime;
				answer++;
			}
		}
		System.out.println(answer);
	}
}
