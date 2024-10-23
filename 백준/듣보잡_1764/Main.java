/*
 * 백준 - 듣보잡
 *
 * https://www.acmicpc.net/problem/1764
 */
package 듣보잡_1764;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Set<String> set = new HashSet<>();
		ArrayList<String> answer = new ArrayList<>();

		int a = scanner.nextInt();
		int b = scanner.nextInt();

		for (int i = 0; i < a; i++) {
			set.add(scanner.next());
		}

		int count = 0;
		for (int i = 0; i < b; i++) {
			String next = scanner.next();
			if (set.contains(next)) {
				answer.add(next);
				count++;
			}
		}

		System.out.println(count);
		Collections.sort(answer);
		for (String ans : answer) {
			System.out.println(ans);
		}
	}
}
