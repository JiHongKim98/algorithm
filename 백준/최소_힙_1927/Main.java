/*
 * 백준 - 최소 힙
 *
 * https://www.acmicpc.net/problem/1927
 */
package 최소_힙_1927;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		PriorityQueue<Long> queue = new PriorityQueue<>();

		int max = scanner.nextInt();
		for (int i = 0; i < max; i++) {
			long currNum = scanner.nextLong();
			if (currNum == 0) {
				if (queue.size() == 0) {
					System.out.println(0);
					continue;
				}
				Long poll = queue.poll();
				System.out.println(poll);
			} else {
				queue.add(currNum);
			}
		}
	}
}
