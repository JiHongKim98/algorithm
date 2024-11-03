/*
 * 백준 - 테트로미노
 *
 * https://www.acmicpc.net/problem/14500
 */
package 테트로미노_14500;

import java.util.Scanner;

public class Main {

	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};

	private static int answer;
	private static int[][] map;
	private static boolean[][] visit;
	private static int maxX;
	private static int maxY;

	public static void main(String[] args) {
		answer = Integer.MIN_VALUE;

		Scanner scanner = new Scanner(System.in);

		maxX = scanner.nextInt();
		maxY = scanner.nextInt();

		map = new int[maxX][maxY];
		visit = new boolean[maxX][maxY];

		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				map[i][j] = scanner.nextInt();
			}
		}

		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				visit[i][j] = true;
				DFS(i, j, map[i][j], 1);

				visit[i][j] = false;
			}
		}

		System.out.println(answer);
	}

	private static void DFS(int x, int y, int value, int count) {
		if (count == 4) {
			answer = Math.max(answer, value);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int currX = x + dx[i];
			int currY = y + dy[i];

			if (
				currX >= 0 && currX < maxX
					&& currY >= 0 && currY < maxY
					&& !visit[currX][currY]
			) {

				if (count == 2) {
					visit[currX][currY] = true;
					DFS(x, y, value + map[currX][currY], count + 1);

					visit[currX][currY] = false;
				}

				visit[currX][currY] = true;
				DFS(currX, currY, value + map[currX][currY], count + 1);

				visit[currX][currY] = false;
			}
		}
	}
}
