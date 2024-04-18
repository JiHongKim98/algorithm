package dp.피보나치수열_1003;
/*
 * 24/04/18
 *
 * 백준(DP) - 피보나치 수열
 *
 * https://www.acmicpc.net/problem/1003
 */

// Think
// - (0 이 호출될 경우, 1이 호출될 경우)
// - 0 일 경우  1, 0
// - 1 일 경우  0, 1
// - 2 일 경우  1, 1
// - 3 일 경우  1, 2
// - 4 일 경우  2, 3
// - 5 일 경우  3, 5
// - 6 일 경우  5, 8
// - ...
// 규칙 => 피보나치 수열을 미리 구하고 0 이 호출된 횟수는 이전 값, 1이 호출된 횟수는 현재 값
// 조건 - 피보나치 수열은 0 ~ 40 인덱스 (41개)
// 조건 - 줄바꿈 해야함.

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int maxCount = scanner.nextInt();  // N
		int[] resultMap = new int[maxCount];
		for (int i = 0; i < maxCount; i++) {
			resultMap[i] = scanner.nextInt();
		}

		int[] fibo = new int[41];
		fibo[0] = 0;
		fibo[1] = 1;

		for (int i = 2; i < 41; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		StringBuilder sb = new StringBuilder();
		for (int result : resultMap) {
			// 0 일 경우에는 이전 값이 없다.
			// 따라서, 0 일 경우 (1, 0) 이 된다.
			if (result == 0) {
				sb.append("1 0\n");
				continue;
			}
			sb.append(fibo[result - 1]).append(" ").append(fibo[result]).append("\n");
		}

		System.out.println(sb);
	}
}
