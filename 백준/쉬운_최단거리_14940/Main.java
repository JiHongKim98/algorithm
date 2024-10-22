/*
 * 백준 - 토마토
 *
 * https://www.acmicpc.net/problem/14940
 */
package 쉬운_최단거리_14940;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) {
		int answer = 0;

		Scanner scanner = new Scanner(System.in);
		final int row = scanner.nextInt();
		final int col = scanner.nextInt();

		int[][] map = new int[row][col];
		boolean[][] visit = new boolean[row][col];

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j] = scanner.nextInt();

				if (map[i][j] == 2) {
					queue.add(new int[] {i, j, answer});
					map[i][j] = 0;
					visit[i][j] = true;
				}

				if (map[i][j] == 0) {
					visit[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int currRow = poll[0];
			int currCol = poll[1];
			int count = poll[2];

			for (int i = 0; i < 4; i++) {
				int newRow = currRow + dx[i];
				int newCol = currCol + dy[i];

				if (
					newRow >= 0 && newRow < row
						&& newCol >= 0 && newCol < col
						&& !visit[newRow][newCol]
				) {
					map[newRow][newCol] = count + 1;
					queue.add(new int[] {newRow, newCol, count + 1});
					visit[newRow][newCol] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!visit[i][j]) {
					sb.append(-1);
				} else {
					sb.append(map[i][j]);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
