/*
 * 프로그래머스 - 입국심사
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/43238
 */
package Lv_3.입국심사;

import java.util.Arrays;

class Solution {

	public long solution(int n, int[] times) {
		Arrays.sort(times);

		long min = 0;
		long max = times[times.length - 1] * (long)n;

		long answer = max;

		while (min <= max) {
			long middle = (min + max) / 2;

			long countPerson = 0;
			for (int time : times) {
				long currentPerson = middle / time;
				countPerson += currentPerson;

				if (countPerson >= n) {
					break;
				}
			}

			if (countPerson < n) {
				min = middle + 1;
			} else {
				max = middle - 1;
				answer = middle;
			}
		}

		return answer;
	}
}
