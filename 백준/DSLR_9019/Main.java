/*
 * 백준 - DSLR
 *
 * https://www.acmicpc.net/problem/9019
 */
package DSLR_9019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int max = scanner.nextInt();

		for (int i = 0; i < max; i++) {
			int now = scanner.nextInt();
			int target = scanner.nextInt();
			doProcess(now, target);
		}
	}

	private static void doProcess(int now, int target) {
		boolean[] visit = new boolean[10_000];

		Queue<String[]> queue = new LinkedList<>();
		queue.add(new String[] {String.valueOf(now), ""});

		while (!queue.isEmpty()) {
			String[] poll = queue.poll();

			int currNum = Integer.parseInt(poll[0]);
			String currFunc = poll[1];
			if (currNum == target) {
				System.out.println(currFunc);
			}

			int D = (currNum * 2) % 10000;
			if (!visit[D]) {
				visit[D] = true;
				queue.add(new String[] {String.valueOf(D), currFunc + "D"});
			}

			int S = currNum == 0 ? 9999 : currNum - 1;
			if (!visit[S]) {
				visit[S] = true;
				queue.add(new String[] {String.valueOf(S), currFunc + "S"});
			}

			int L = (currNum % 1000) * 10 + (currNum / 1000);
			if (!visit[L]) {
				visit[L] = true;
				queue.add(new String[] {String.valueOf(L), currFunc + "L"});
			}

			int R = (currNum % 10) * 1000 + (currNum / 10);
			if (!visit[R]) {
				visit[R] = true;
				queue.add(new String[] {String.valueOf(R), currFunc + "R"});
			}
		}
	}
}
