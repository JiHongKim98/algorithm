/*
 * 백준(이진탐색) - DFS와 BFS
 *
 * https://www.acmicpc.net/problem/1260
 */
package DFS와_BFS_1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private static StringBuilder stringBuilder = new StringBuilder();

	private static int nodeTotal;
	private static int lineTotal;

	private static boolean[][] map;
	private static boolean[] visit;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		nodeTotal = scanner.nextInt();
		lineTotal = scanner.nextInt();
		int startNode = scanner.nextInt();

		map = new boolean[nodeTotal + 1][nodeTotal + 1];

		for (int i = 0; i < lineTotal; i++) {
			int node1 = scanner.nextInt();
			int node2 = scanner.nextInt();

			map[node1][node2] = map[node2][node1] = true;
		}

		visit = new boolean[nodeTotal + 1];
		DFS(startNode);
		stringBuilder.append("\n");

		visit = new boolean[nodeTotal + 1];
		BFS(startNode);

		System.out.println(stringBuilder.toString());
	}

	private static void DFS(int node) {
		visit[node] = true;
		stringBuilder.append(node + " ");

		for (int i = 0; i <= nodeTotal; i++) {
			if (map[node][i] && !visit[i]) {
				DFS(i);
			}
		}
	}

	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);

		visit[node] = true;

		while (!queue.isEmpty()) {
			Integer pollNode = queue.poll();
			stringBuilder.append(pollNode + " ");

			for (int i = 0; i <= nodeTotal; i++) {
				if (map[pollNode][i] && !visit[i]) {
					visit[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
