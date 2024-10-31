/*
 * 프로그래머스 - N으로 표현
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42895
 */
package Lv_3.N으로_표현;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

	public int solution(int N, int number) {
		if (N == number) {
			return 1;
		}

		List<Set<Integer>> mem = new ArrayList<>();
		for (int i = 0; i <= 8; i++) {
			mem.add(new HashSet<>());
		}

		mem.get(1).add(N);
		for (int i = 2; i <= 8; i++) {
			Set<Integer> nowSet = mem.get(i);

			String repeatedN = Integer.toString(N).repeat(i);
			nowSet.add(Integer.parseInt(repeatedN));

			for (int j = 1; j < i; j++) {
				Set<Integer> set1 = mem.get(j);
				Set<Integer> set2 = mem.get(i - j);

				for (int num1 : set1) {
					for (int num2 : set2) {
						nowSet.add(num1 + num2);
						nowSet.add(num1 - num2);
						nowSet.add(num1 * num2);
						if (num2 != 0) {
							nowSet.add(num1 / num2);
						}
					}
				}
			}

			if (nowSet.contains(number)) {
				return i;
			}
		}

		return -1;
	}
}
