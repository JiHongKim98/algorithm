package N과_M_1_15649;
/* 백준(백트래킹) - N과 M(1)
 *
 * https://www.acmicpc.net/problem/15649
 */

import java.util.Scanner;
import java.util.Stack;

public class Main {

	private static boolean[] visit;
	private static Stack<Integer> stack;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int 숫자 = scanner.nextInt();
		int 개수 = scanner.nextInt();

		stack = new Stack<>();

		visit = new boolean[숫자];

		DFS(숫자, 개수, 0);
	}

	private static void DFS(int 숫자, int 개수, int count) {
		if (count == 개수) {
			String string = stack.toString();
			String replace = string.replace("[", "").replace("]", "").replace(",", "");
			System.out.println(replace);
			return;
		}

		for (int i = 0; i < 숫자; i++) {
			if (visit[i]) {
				continue;
			}

			visit[i] = true;
			stack.add(i + 1);
			DFS(숫자, 개수, count + 1);

			visit[i] = false;
			stack.pop();
		}
	}
}
