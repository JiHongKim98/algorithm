/*
 * 프로그래머스 - 단속카메라
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884
 */
package Lv_3.단속카메라;

import java.util.Arrays;

class Solution {

	public int solution(int[][] routes) {
		int answer = 0;

		Arrays.sort(routes, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		int point = -1;
		for (int i = 0; i < routes.length; i++) {
			int startPoint = routes[i][0];
			int endPoint = routes[i][1];

			if (point == -1 || startPoint > point) {
				point = endPoint;
				answer++;
				continue;
			}

			if (endPoint < point) {
				point = endPoint;
			}
		}

		return answer;
	}
}
