package 스택.괄호_9012;
/* 백준(스택) - 괄호
 *
 * https://www.acmicpc.net/problem/9012
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int nextInt = sc.nextInt();

		for (int i = 0; i < nextInt; i++) {
			Stack<Integer> stack = new Stack<>();

			String next = sc.next();

			int a = 0;
			int b = 0;

			boolean isValid = true;

			for (int j = 0; j < next.length(); j++) {
				if (next.charAt(j) == '(') {
					stack.add(j);
					a++;
				} else {
					b++;
					if (stack.isEmpty()) {
						System.out.println("NO");
						isValid = false;
						break;
					}
					stack.pop();
				}
			}

			if (isValid && stack.isEmpty() && a == b) {
				System.out.println("YES");
			} else if (isValid) {
				System.out.println("NO");
			}
		}

	}
}
