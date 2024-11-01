/*
 * 백준(덱큐) - AC
 *
 * https://www.acmicpc.net/problem/5430
 */
package AC_5430;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int maxCount = scanner.nextInt();

		for (int i = 0; i < maxCount; i++) {
			String linedFunc = scanner.next();
			int argsCount = scanner.nextInt();
			String array = scanner.next();

			doFunction(linedFunc, argsCount, array);
		}
	}

	private static void doFunction(String linedFunc, int argsCount, String array) {
		Deque<Integer> queue = new LinkedList<>();

		if (argsCount > 0) {
			String replace1 = array.replace("[", "");
			String replace2 = replace1.replace("]", "");
			String[] stringArray = replace2.split(",");

			for (String string : stringArray) {
				queue.add(Integer.parseInt(string));
			}
		}

		boolean isReverse = false;
		for (String func : linedFunc.split("")) {
			if (func.equals("D")) {
				if (queue.isEmpty()) {
					System.out.println("error");
					return;
				}

				if (isReverse) {
					queue.removeLast();
				} else {
					queue.removeFirst();
				}
			}

			if (func.equals("R")) {
				isReverse = !isReverse;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while (!queue.isEmpty()) {
			sb.append(isReverse ? queue.removeLast() : queue.removeFirst());
			if (!queue.isEmpty()) {
				sb.append(",");
			}
		}
		sb.append("]");
		System.out.println(sb);
	}
}
