package 네모네모_시력검사_18242;
/* 백준(구현) - 네모네모 시력검사
 *
 * https://www.acmicpc.net/problem/18242
 */

import java.util.Scanner;

public class Main {

	private static char[][] map;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int row = scanner.nextInt();
		int col = scanner.nextInt();

		map = new char[row][col];

		boolean startFlag = false;

		int startX = -1;
		int startY = -1;

		int endX = -1;
		int endY = -1;

		for (int i = 0; i < row; i++) {
			String line = scanner.next();

			for (int j = 0; j < col; j++) {
				char c = line.charAt(j);
				map[i][j] = c;

				if (!startFlag && c == '#') {
					startFlag = true;
					startX = i;
					startY = j;
				} else if (c == '#') {
					endX = i;
					endY = j;
				}
			}
		}

		for (int i = startX; i <= endX; i++) {
			if (map[i][startY] != '#') {
				System.out.println("LEFT");
				return;
			}

			if (map[i][endY] != '#') {
				System.out.println("RIGHT");
				return;
			}
		}

		for (int i = startY; i <= endY; i++) {
			if (map[startX][i] != '#') {
				System.out.println("UP");
				return;
			}

			if (map[endX][i] != '#') {
				System.out.println("DOWN");
				return;
			}
		}
	}
}
