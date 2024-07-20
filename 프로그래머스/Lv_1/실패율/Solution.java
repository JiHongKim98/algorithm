/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 */
package Lv_1.실패율;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	public List<Integer> solution(int N, int[] stages) {
		// 각 스테이지에 도달한 players 계산
		int[] tempStage = new int[N];

		for (int stage : stages) {
			if (stage > N)
				continue;

			tempStage[stage - 1] += 1;
		}

		// 스테이지 실패율 계산
		int totP = stages.length;  // 총 player
		double[] failRates = new double[N];  // 각 스테이지의 실패율

		for (int i = 0; i < N; i++) {
			if (totP == 0) {  // 해당 스테이지 (i 스테이지) 에 사용자가 없는 경우
				failRates[i] = 0;
			} else {
				failRates[i] = (double)tempStage[i] / totP;
				totP = totP - tempStage[i];
			}
		}

		// 큰 수부터 내림차순 정렬
		List<Integer> answer = new ArrayList<>();

		Integer[] indexArray = new Integer[N];
		for (int i = 0; i < N; i++) {
			indexArray[i] = i;
		}

		Arrays.sort(indexArray, (a, b) -> {
			if (failRates[a] == failRates[b]) {
				return a - b;  // 값이 같은 경우 idx 가 작은 순
			}
			return Double.compare(failRates[b], failRates[a]);  // 내림차순
		});

		for (int i = 0; i < N; i++) {
			answer.add(indexArray[i] + 1);
		}

		return answer;
	}
}
