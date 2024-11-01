package 토마토_7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private static final int[] dx = {0, 0, -1, 1, 0, 0};
	private static final int[] dy = {1, -1, 0, 0, 0, 0};
	private static final int[] dz = {0, 0, 0, 0, -1, 1};

	public static void main(String[] args) {
		int answer = 0;

		Scanner scanner = new Scanner(System.in);
		int maxX = scanner.nextInt();
		int maxY = scanner.nextInt();
		int maxZ = scanner.nextInt();

		int[][][] map = new int[maxX][maxY][maxZ];
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] visit = new boolean[maxX][maxY][maxZ];

		for (int k = 0; k < maxZ; k++) {
			for (int j = 0; j < maxY; j++) {
				for (int i = 0; i < maxX; i++) {
					map[i][j][k] = scanner.nextInt();

					if (map[i][j][k] == 1) {
						queue.add(new int[] {i, j, k, 0});
						visit[i][j][k] = true;
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();

			int currX = poll[0];
			int currY = poll[1];
			int currZ = poll[2];

			int count = poll[3];

			for (int i = 0; i < 6; i++) {
				int nx = currX + dx[i];
				int ny = currY + dy[i];
				int nz = currZ + dz[i];

				if (
					nx >= 0 && nx < maxX
						&& ny >= 0 && ny < maxY
						&& nz >= 0 && nz < maxZ
						&& !visit[nx][ny][nz]
						&& map[nx][ny][nz] == 0
				) {
					queue.add(new int[] {nx, ny, nz, count + 1});
					visit[nx][ny][nz] = true;
					map[nx][ny][nz] = 1;
				}
			}
			answer = count;
		}

		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				for (int k = 0; k < maxZ; k++) {
					if (map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
