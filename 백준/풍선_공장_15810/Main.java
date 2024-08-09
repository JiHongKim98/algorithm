package 풍선_공장_15810;
/* 백준(이진탐색) - 풍선 공장
 *
 * https://www.acmicpc.net/problem/15810
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int staffCount = sc.nextInt();  // 스태프 수
		int minBalloon = sc.nextInt();  // 최소 풍선 갯수

		int[] time = new int[staffCount];
		for (int i = 0; i < staffCount; i++) {
			time[i] = sc.nextInt();
		}

		Arrays.sort(time);

		// 최대로 걸릴 수 있는 시간을 문제 읽고 잘 생각하자
		// 직원 한 명이 최대 시간으로 최대 갯수의 풍선을 만들어야 할 때가 최대 시간
		long left = 1;
		long right = (long)time[time.length - 1] * minBalloon; // right를 long으로 잡아도 연산하는 숫자들도 long으로 지정해줘야..
		long result = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long count = 0;

			for (int i = 0; i < staffCount; i++) {
				count += mid / time[i];
			}

			if (count >= minBalloon) {
				result = mid;
				right = mid - 1;
			} else if (count < minBalloon) {
				left = mid + 1;
			}
		}
		System.out.println(result);
	}
}
