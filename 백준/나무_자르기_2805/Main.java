package 나무_자르기_2805;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int treeCount = scanner.nextInt();
		int wishHeight = scanner.nextInt();

		int[] treeMap = new int[treeCount];

		int min = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < treeCount; i++) {
			treeMap[i] = scanner.nextInt();
			max = Math.max(treeMap[i], max);
		}

		while (min <= max) {
			int middle = (min + max) / 2;

			long total = 0;
			for (int treeHeight : treeMap) {
				int currentHeight = treeHeight - middle;
				if (currentHeight > 0) {
					total += currentHeight;
				}
			}

			if (total < wishHeight) {
				max = middle - 1;
			} else {
				min = middle + 1;
			}
		}

		System.out.println(min - 1);
	}
}
