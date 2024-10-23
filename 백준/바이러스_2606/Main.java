/*
 * 백준(그래프) - 바이러스
 *
 * https://www.acmicpc.net/problem/2606
 */
package 바이러스_2606;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int node = scanner.nextInt();
		int link = scanner.nextInt();

		boolean[] visit = new boolean[node + 1];
		boolean[][] map = new boolean[node + 1][node + 1];

		for (int i = 0; i < link; i++) {
			int node1 = scanner.nextInt();
			int node2 = scanner.nextInt();
			map[node1][node2] = map[node2][node1] = true;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visit[1] = true;

		int count = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 1; i <= node; i++) {
				if (!visit[i] && map[now][i]) {
					queue.add(i);
					count++;
					visit[i] = true;
				}
			}
		}

		System.out.println(count);
	}
}
