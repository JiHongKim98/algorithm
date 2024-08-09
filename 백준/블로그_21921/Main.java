package 블로그_21921;
/* 백준(누적합) - 블로그
 *
 * https://www.acmicpc.net/problem/21921
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

	private static int count = 0;
	private static int maxVisit = 0;
	private static int nowVisit = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int maxVisitListNum = sc.nextInt();
		int maxDate = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < maxVisitListNum; i++) {
			int today = sc.nextInt();

			queue.add(today);

			nowVisit += today;
			if (nowVisit > maxVisit) {
				count = 1;
				maxVisit = nowVisit;
			} else if (nowVisit == maxVisit) {
				count++;
			}

			if (i >= maxDate - 1) {
				Integer peek = queue.poll();
				nowVisit -= peek;
			}
		}

		if (maxVisit == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(maxVisit);
			System.out.println(count);
		}
	}
}
