// 아직 못품

package 그래프.바이러스_2606;
/* 백준(그래프) - 바이러스
 *
 * https://www.acmicpc.net/problem/2606
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {

	private static Map<Integer, List<Integer>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int maxNode = sc.nextInt();
		int maxLink = sc.nextInt();

		map = new HashMap<>();

		for (int i = 0; i < maxLink; i++) {
			int i1 = sc.nextInt();
			int i2 = sc.nextInt();

			map.putIfAbsent(i1, new ArrayList<>());
			map.get(i1).add(i2);

			map.putIfAbsent(i2, new ArrayList<>());
			map.get(i2).add(i1);
		}

		DFS(0, 1, map);
	}

	private static void DFS(int count, int startIdx, Map<Integer, List<Integer>> map) {
		List<Integer> integers = map.get(startIdx);

		for (Integer i : integers) {
			DFS(count + 1, i, map);
		}
	}
}
