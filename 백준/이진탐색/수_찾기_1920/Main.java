package 이진탐색.수_찾기_1920;
/* 백준(이진탐색) - 수 찾기
 *
 * https://www.acmicpc.net/problem/1920
 */

import java.util.Arrays;
import java.util.Scanner;

class Main {

	private static int[] intMap;
	private static int[] targetMap;
	private static int maxBase;
	private static int maxTarget;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		maxBase = sc.nextInt();
		intMap = new int[maxBase];

		for (int i = 0; i < maxBase; i++) {
			intMap[i] = sc.nextInt();
		}

		Arrays.sort(intMap);

		maxTarget = sc.nextInt();
		targetMap = new int[maxTarget];

		for (int i = 0; i < maxTarget; i++) {
			targetMap[i] = sc.nextInt();
		}

		for (int i = 0; i < maxTarget; i++) {
			search(targetMap[i], i);
		}
	}

	private static void search(int num, int i) {
		int min = 0;
		int max = maxBase - 1;
		int half;

		boolean 있나요 = false;

		while (min <= max) {
			half = (max + min) / 2;

			if (intMap[half] > num) {
				max = half - 1;
			} else if (intMap[half] < num) {
				min = half + 1;
			} else if (intMap[half] == num) {
				있나요 = true;
				break;
			}
		}

		if (있나요) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
}
