/*
 * 백준 - 연결 요소의 개수
 *
 * https://www.acmicpc.net/problem/11724
 */
package 연결_요소의_개수_11724;

import java.util.Scanner;

public class Main {

	private static int maxNode;
	private static int maxLine;
	private static boolean[] visit;
	private static boolean[][] map;

	public static void main(String[] args) {
		int answer = 0;

		Scanner scanner = new Scanner(System.in);

		maxNode = scanner.nextInt();
		maxLine = scanner.nextInt();

		map = new boolean[maxNode + 1][maxNode + 1];
		visit = new boolean[maxNode + 1];

		for (int i = 0; i < maxLine; i++) {
			int node1 = scanner.nextInt();
			int node2 = scanner.nextInt();

			map[node1][node2] = map[node2][node1] = true;
		}

		for (int i = 1; i <= maxNode; i++) {
			if (!visit[i]) {
				DFS(i);
				answer++;
			}
		}

		System.out.println(answer);
	}

	private static void DFS(int node) {
		visit[node] = true;

		for (int i = 1; i <= maxNode; i++) {
			if (!visit[i] && map[node][i]) {
				DFS(i);
			}
		}
	}
}
