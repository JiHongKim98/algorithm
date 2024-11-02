/*
 * 백준 - 이중 우선순위
 *
 * https://www.acmicpc.net/problem/7662
 */
package 이중_우선순위_큐_7662;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testcase = scanner.nextInt();

		for (int i = 0; i < testcase; i++) {
			int func = scanner.nextInt();
			scanner.nextLine();

			TreeMap<Integer, Integer> map = new TreeMap<>();

			for (int j = 0; j < func; j++) {
				String nextLine = scanner.nextLine();
				String[] split = nextLine.split(" ");

				int number = Integer.parseInt(split[1]);

				if (split[0].equals("I")) {
					map.put(number, map.getOrDefault(number, 0) + 1);
				}

				if (split[0].equals("D")) {
					if (map.size() == 0) {
						continue;
					}

					int KEY = number == 1 ? map.lastKey() : map.firstKey();
					Integer currValue = map.get(KEY);
					if (currValue == 1) {
						map.remove(KEY);
					} else {
						map.put(KEY, currValue - 1);
					}
				}
			}

			if (map.size() == 0) {
				System.out.println("EMPTY");
			} else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		}
	}
}
