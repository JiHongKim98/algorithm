/*
 * 프로그래머스 - 징검다리
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/43236
 */
package Lv_4.징검다리;

import java.util.Arrays;

class Solution {

	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;

		Arrays.sort(rocks);

		int left = 0;
		int right = distance;

		while (left <= right) {
			int middle = (left + right) / 2;

			int nowRemoveCount = 0;
			int cursor = 0;

			for (int i = 0; i < rocks.length; i++) {
				int diff = rocks[i] - cursor;

				if (diff < middle) {
					nowRemoveCount++;
				} else {
					cursor = rocks[i];
				}
			}

			int lastDiff = distance - cursor;
			if (lastDiff < middle) {
				nowRemoveCount++;
			}

			if (nowRemoveCount <= n) {
				answer = middle;
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return answer;
	}
}
