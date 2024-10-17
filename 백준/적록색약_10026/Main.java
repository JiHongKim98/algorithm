/*
 * 백준(이진탐색) - 적록색약
 *
 * https://www.acmicpc.net/problem/10026
 */
package 적록색약_10026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {1, -1, 0, 0};

	private static int maxN;
	private static char[][] map;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		maxN = scanner.nextInt();
		map = new char[maxN][maxN];

		for (int i = 0; i < maxN; i++) {
			String line = scanner.next();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j);
			}
		}

		int normalCount = 0;
		int colorBlindCount = 0;

		boolean[][] normalVisit = new boolean[maxN][maxN];
		for (int i = 0; i < maxN; i++) {
			for (int j = 0; j < maxN; j++) {
				if (!normalVisit[i][j]) {
					bfs(i, j, false, normalVisit);
					normalCount++;
				}
			}
		}

		boolean[][] colorBlindVisit = new boolean[maxN][maxN];
		for (int i = 0; i < maxN; i++) {
			for (int j = 0; j < maxN; j++) {
				if (!colorBlindVisit[i][j]) {
					bfs(i, j, true, colorBlindVisit);
					colorBlindCount++;
				}
			}
		}

		System.out.println(normalCount + " " + colorBlindCount);
	}

	private static void bfs(int startX, int startY, boolean isColorBlind, boolean[][] visit) {
		visit[startX][startY] = true;

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(startX, startY));

		char target = map[startX][startY];

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x = node.x + dx[i];
				int y = node.y + dy[i];

				if (x >= 0 && x < maxN && y >= 0 && y < maxN && !visit[x][y]) {
					if (target == map[x][y]) {
						queue.add(new Node(x, y));
						visit[x][y] = true;
						continue;
					}

					if (
						isColorBlind &&
							(target == 'R' || target == 'G') &&
							(map[x][y] == 'R' || map[x][y] == 'G')
					) {
						queue.add(new Node(x, y));
						visit[x][y] = true;
					}
				}
			}
		}
	}

	private static class Node {
		private int x;
		private int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
