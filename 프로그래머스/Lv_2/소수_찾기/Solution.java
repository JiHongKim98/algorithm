/*
 * 프로그래머스 - 소수 찾기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */
package Lv_2.소수_찾기;

import java.util.HashSet;
import java.util.Set;

class Solution {

	private Set<Integer> answer;

	public int solution(String numbers) {
		answer = new HashSet<>();

		boolean[] visit = new boolean[numbers.length()];
		for (int i = 1; i <= numbers.length(); i++) {
			DFS(visit, numbers, 0, "", i);
		}

		return answer.size();
	}

	private void DFS(boolean[] visit, String numbers, int depth, String nowString, int 자리수) {
		if (depth == 자리수) {
			int num = Integer.parseInt(nowString);

			if (num == 0) {
				return;
			}

			if (isPrime(num)) {
				answer.add(num);
			}
			return;
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (visit[i]) {
				continue;
			}

			visit[i] = true;
			DFS(visit, numbers, depth + 1, nowString + numbers.charAt(i), 자리수);
			visit[i] = false;
		}
	}

	private boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}

		if (num == 2) {
			return true;
		}

		for (int i = 2; i < Math.sqrt(num) + 1; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
