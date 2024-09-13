package 숫자_정사각형_1051;
/* 백준(브루트포스) - 숫자 정사각형
 *
 * https://www.acmicpc.net/problem/1051
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int answer = 1;

		int row = scanner.nextInt();
		int col = scanner.nextInt();

		int min = Math.min(row, col);

		int[][] map = new int[row][col];

		for (int i = 0; i < row; i++) {
			String next = scanner.next();
			String[] split = next.split("");

			for (int j = 0; j < col; j++) {
				String s = split[j];
				int parseInt = Integer.parseInt(s);
				map[i][j] = parseInt;
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int correct = map[i][j];

				for (int k = 1; k < min; k++) {
					if (
						(i + k < row && j + k < col) &&
							map[i][j + k] == correct &&
							map[i + k][j] == correct &&
							map[i + k][j + k] == correct) {
						answer = Math.max(answer, (k + 1) * (k + 1));
					}
				}
			}
		}
		System.out.println(answer);
	}
}
