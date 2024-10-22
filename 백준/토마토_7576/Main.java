/*
 * 백준 - 토마토
 *
 * https://www.acmicpc.net/problem/1074
 */
package 토마토_7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};

	private static int[][] map;
	private static boolean[][] visit;

	public static void main(String[] args) {
		int answer = 0;

		Scanner scanner = new Scanner(System.in);
		int maxY = scanner.nextInt();
		int maxX = scanner.nextInt();

		map = new int[maxX][maxY];
		visit = new boolean[maxX][maxY];

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				map[i][j] = scanner.nextInt();
				if (map[i][j] == 1) {
					queue.add(new int[] {i, j, answer});
					visit[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();

			int currX = poll[0];
			int currY = poll[1];
			int count = poll[2];

			for (int i = 0; i < 4; i++) {
				int nx = currX + dx[i];
				int ny = currY + dy[i];

				if (
					nx >= 0 && nx < maxX
						&& ny >= 0 && ny < maxY
						&& !visit[nx][ny]
						&& map[nx][ny] == 0
				) {
					queue.add(new int[] {nx, ny, count + 1});
					visit[nx][ny] = true;
					map[nx][ny] = 1;
				}
			}
			answer = count;
		}

		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(answer);
	}
}
