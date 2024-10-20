/*
 * 프로그래머스 - 단어 변환
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
package Lv_3.단어_변환;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		boolean[] visit = new boolean[words.length];

		Queue<String> queue = new LinkedList<>();
		Queue<Integer> queueCount = new LinkedList<>();
		queue.add(begin);
		queueCount.add(0);

		while (!queue.isEmpty()) {
			String current = queue.poll();
			int currentCount = queueCount.poll();

			if (current.equals(target)) {
				answer = currentCount;
				break;
			}

			for (int i = 0; i < words.length; i++) {
				if (
					!visit[i]
						&& isPos(current, words[i])
				) {
					queue.add(words[i]);
					queueCount.add(currentCount + 1);
					visit[i] = true;
				}
			}
		}

		return answer;
	}

	private boolean isPos(String current, String target) {
		int len = current.length();
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (current.charAt(i) != target.charAt(i)) {
				count++;
			}

			if (count >= 2) {
				return false;
			}
		}
		return true;
	}
}
