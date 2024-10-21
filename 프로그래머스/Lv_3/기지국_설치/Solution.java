/*
 * 프로그래머스 - 기지국 설치
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12979
 */
package Lv_3.기지국_설치;

class Solution {

	private int width;

	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		width = w;

		int start = 1;
		for (int i = 0; i < stations.length; i++) {
			if (start < stations[i] - width) {
				int end = stations[i] - width - 1;
				answer += check(start, end);
			}
			start = stations[i] + width + 1;
		}

		if (stations[stations.length - 1] + width < n) {
			start = stations[stations.length - 1] + width + 1;
			answer += check(start, n);
		}

		return answer;
	}

	public int check(int start, int end) {
		int result = (end - start + 1) / (2 * width + 1);
		if ((end - start + 1) % (2 * width + 1) > 0) {
			return result + 1;
		}
		return result;
	}
}
