package 좌표_압축_18870;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int max = scanner.nextInt();

		int[] origin = new int[max];

		for (int i = 0; i < max; i++) {
			origin[i] = scanner.nextInt();
		}

		int[] sortedOrigin = origin.clone();
		Arrays.sort(sortedOrigin);
		Map<Integer, Integer> map = new HashMap<>();

		int count = 0;
		for (int i = 0; i < max; i++) {
			if (!map.containsKey(sortedOrigin[i])) {
				map.put(sortedOrigin[i], count++);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < max; i++) {
			Integer idx = map.get(origin[i]);
			sb.append(idx).append(" ");
		}
		System.out.println(sb);
	}
}
