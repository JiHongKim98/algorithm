package 뱀과_사다리_게임;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private static final int finishPoint = 100;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int sadari = scanner.nextInt();
		int baem = scanner.nextInt();
		int total = sadari + baem;

		int[] map = new int[101];
		boolean[] visit = new boolean[101];

		for (int i = 0; i < total; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			map[start] = end;
		}

		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> queueCount = new LinkedList<>();
		queue.add(1);
		queueCount.add(0);

		while (!queue.isEmpty()) {
			int now = queue.poll();
			int nowCount = queueCount.poll();

			for (int i = 1; i <= 6; i++) {
				int temp = now + i;

				if (temp == finishPoint) {
					System.out.println(nowCount + 1);
					return;
				}

				if (!visit[temp]) {
					visit[temp] = true;
					if (map[temp] != 0) {
						temp = map[temp];
						visit[temp] = true;
					}
					queue.add(temp);
					queueCount.add(nowCount + 1);
				}
			}
		}
	}
}
