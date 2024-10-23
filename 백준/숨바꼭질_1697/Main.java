package 숨바꼭질_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] visitMap = new int[100_001];

		Scanner scanner = new Scanner(System.in);
		int currentPos = scanner.nextInt();
		int target = scanner.nextInt();

		if (currentPos == target) {
			System.out.println(0);
			return;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(currentPos);
		visitMap[currentPos] = 1;

		while (!queue.isEmpty()) {
			int poll = queue.poll();

			for (int i = 0; i < 3; i++) {
				int nextPos = move(poll, i);

				if (nextPos == target) {
					System.out.println(visitMap[poll]);
					return;
				}

				if (nextPos >= 0 && nextPos < 100_001 && visitMap[nextPos] == 0) {
					queue.add(nextPos);
					visitMap[nextPos] = visitMap[poll] + 1;
				}
			}
		}
	}

	private static int move(int pos, int moveCount) {
		if (moveCount == 0) {
			return pos + 1;
		} else if (moveCount == 1) {
			return pos - 1;
		} else {
			return pos * 2;
		}
	}
}
