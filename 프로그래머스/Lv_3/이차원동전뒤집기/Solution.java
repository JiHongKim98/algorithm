/*
 * 24/06/13
 *
 * 프로그래머스 - 2차원 동전 뒤집기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131703
 */
package Lv_3.이차원동전뒤집기;

class Solution {

	private static int endRowNum, endColNum;
	private static int[][] beMap, taMap;  // 시작 배열과 목표 배열

	private static int minCount = Integer.MAX_VALUE;  // 뒤집는 횟수의 최솟값

	public static int solution(int[][] beginning, int[][] target) {
		// initial
		beMap = beginning;
		taMap = target;
		endRowNum = beMap.length;
		endColNum = beMap[0].length;

		DFS(0, 0);

		// minCount 가 갱신되지 않았다? -> target에 대한 조합이 없다.
		if (minCount == Integer.MAX_VALUE) {
			return -1;  // 목표 배열을 만들 수 없음
		}
		return minCount;
	}

	private static void DFS(int count, int nowRowIdx) {
		// 종료 조건
		if (nowRowIdx == endRowNum) {
			목표에_달성할_수_있는지_확인한다(count);
			return;
		}

		현재_행을_뒤집는다(nowRowIdx);
		DFS(count + 1, nowRowIdx + 1);  // 뒤집은 상태로 다음 행 탐색

		현재_행을_뒤집는다(nowRowIdx);  // 한번더 뒤집어서 원상태로 복구 (ex. 0 -> 1 -> 0)
		DFS(count, nowRowIdx + 1);  // 뒤집지 않은 상태로 다음 행을 탐색
	}

	private static void 현재_행을_뒤집는다(int rowIdx) {
		for (int i = 0; i < endColNum; i++) {
			beMap[rowIdx][i] = 1 - beMap[rowIdx][i];
		}
	}

	// 행 들을 확인하면서 목표 배열에 달성 할 수 있는지 확인
	// 목표에 달성 가능한 경우 -> minCount 갱신
	private static void 목표에_달성할_수_있는지_확인한다(int count) {
		for (int i = 0; i < endColNum; i++) {

			int diffCount = 0;  // 현재 행에서 현재 다른 요소의 개수
			for (int j = 0; j < endRowNum; j++) {  // 현재 행의 요소가 일치하는지 확인

				if (beMap[j][i] != taMap[j][i]) {
					diffCount++;
				}
			}

			if (diffCount != 0 && diffCount != endRowNum) {  // 조합을 만들 수 없는 경우
				return;
			}

			if (diffCount == endRowNum) {  // 현재 행을 뒤집으면 목표 행에 도달 하는 경우
				count++;  // 현재 행 한번 뒤집음
			}
		}

		// 뒤집는 횟수의 최솟값 갱신
		minCount = Math.min(minCount, count);
	}
}
