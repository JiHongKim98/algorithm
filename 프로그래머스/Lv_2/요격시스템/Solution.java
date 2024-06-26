/*
 * 24/06/24
 *
 * 프로그래머스 - 요격 시스템
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */
package Lv_2.요격시스템;

import java.util.Arrays;

class Solution {

	public int solution(int[][] targets) {
		int answer = 0;

		// 시작점 기준으로 오름차순으로 정렬
		// -> 구간 탐색마다 가장 많은 구간을 커버할 수 있도록 구현하기 위함 (그리디)
		Arrays.sort(targets, (o1, o2) -> {
			// 정렬 조건     1. 0번째 인덱스 기준    2. 1번째 인덱스 기준
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		// 시작점이 0 부터 시작이라서 `-1` 로 initial
		int 요격지점 = -1;
		for (int i = 0; i < targets.length; i++) {
			int startPoint = targets[i][0];
			int endPoint = targets[i][1];

			// 현재 구간에서 시작점이 이전 구간에서의 끝점보다 크거나 같을 경우 -> 요격 지점 추가
			// -> 현재 요격 지점으로 커버하지 못함 (구간 간에 공백이 생기므로)
			if (
				요격지점 == -1 ||  // 첫 시작 때, 요격 지점을 추가하고 시작
					startPoint >= 요격지점
			) {
				요격지점 = endPoint;
				answer++;
				continue;
			}

			// 현재 구간에서 끝점이 이전에 선택된 구간의 끝점보다 작을 경우 -> 요격 지점 갱신
			// -> 현재 요격 지점으로 커버 가능함
			if (endPoint < 요격지점) {
				요격지점 = endPoint;
			}
		}

		return answer;
	}
}
