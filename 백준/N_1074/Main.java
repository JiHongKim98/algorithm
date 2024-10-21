/*
 * 백준(분할정복) - N
 *
 * https://www.acmicpc.net/problem/1074
 */
package N_1074;

import java.util.Scanner;

public class Main {

	private static int answer;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = (int)Math.pow(2, scanner.nextInt());
		int x = scanner.nextInt();
		int y = scanner.nextInt();

		분할정복(x, y, size);
		System.out.println(answer);
	}

	private static void 분할정복(int x, int y, int size) {
		if (size == 1) {
			return;
		}

		if (x < size / 2 && y < size / 2) {  // 1사분면
			분할정복(x, y, size / 2);
		} else if (x < size / 2 && y >= size / 2) {  // 2사분면
			answer += size * size / 4;
			분할정복(x, y - size / 2, size / 2);
		} else if (x >= size / 2 && y < size / 2) {  // 3사분면
			answer += (size * size / 4) * 2;
			분할정복(x - size / 2, y, size / 2);
		} else {  // 4사분면
			answer += (size * size / 4) * 3;
			분할정복(x - size / 2, y - size / 2, size / 2);
		}
	}
}
