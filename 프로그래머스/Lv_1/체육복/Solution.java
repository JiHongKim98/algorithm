/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
package Lv_1.체육복;

import java.util.Arrays;

class Solution {

	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		Arrays.sort(reserve);
		Arrays.sort(lost);

		// 도난 안당한 사람수
		answer += n - lost.length;

		// 여벌이 있지만 도난 당한 사람
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					answer += 1;
					lost[i] = -1;
					reserve[j] = -1;
					break;
				}
			}
		}

		// 빌릴 수 있는 사람수
		for (int k : lost) {
			for (int j = 0; j < reserve.length; j++) {
				if (k - 1 == reserve[j] || k + 1 == reserve[j]) {
					answer += 1;
					reserve[j] = -1;
					break;
				}
			}
		}

		return answer;
	}
}
