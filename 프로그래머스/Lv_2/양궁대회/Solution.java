/*
 * 24/06/12
 *
 * 프로그래머스 - 양궁대회
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/92342
 */
package Lv_2.양궁대회;

// OUTPUT - 가장 큰 점수차가 여러개 일 경우, 가장 낮은 점수를 더 맞힌 경우의 수로 반환

// THINK
// - 어떤 방법으로 풀 건가 : 백트래킹? DFS?

class Solution {

	private static int maxArrow;  // 최대 화살을 쏠 횟수
	private static int[] ryanMap = new int[11];  // 라이언이 점수판에 화살을 맞춘 Map
	private static int maxDiff = Integer.MIN_VALUE;  // 점수 차이의 최대값

	private static int[] answer;

	public static int[] solution(int n, int[] info) {
		maxArrow = n;

		DFS(info, 0, 0);

		if (maxDiff <= 0) {
			return new int[] {-1};
		}
		return answer;
	}

	private static void DFS(int[] apeachMap, int depth, int index) {
		// 종료 조건1
		if (depth == maxArrow) {  // 더이상 날릴 화살이 없는 경우
			점수의_최대_차이_갱신(apeachMap);
			return;
		}

		// 종료 조건2
		if (index >= apeachMap.length) {  // 과녁의 배열 길이를 초과한 경우
			return;
		}

		// 현재 과녁 index 에 화살을 쏘는 경우
		ryanMap[index] += 1;
		DFS(apeachMap, depth + 1, index);  // 화살을 사용한 상태로 다음 탐색

		ryanMap[index] -= 1;  // 원상태로 복구

		// 현재 과녁 index 에 화살을 쏘지 않는 경우
		DFS(apeachMap, depth, index + 1);  // 화살을 사용하지 않고 다음 인덱스로 이동
	}

	private static void 점수의_최대_차이_갱신(int[] apeachMap) {
		int diff = 0;  // (라이언 - 어피치) 값 -> 라이언 기준으로 생각

		for (int i = 0; i < apeachMap.length; i++) {
			if (ryanMap[i] > apeachMap[i]) {  // 라이언이 점수를 얻는 경우
				diff += (10 - i);
			} else if (apeachMap[i] > 0) {  // 어피치가 점수를 얻는 경우 = (라이언이 점수를 잃는 경우)
				diff -= (10 - i);
			}
		}

		// 최대 차이 값으로 갱신

		// 최적화(?) 지점
		// OR 문에서 (diff > maxDiff) 결과가 `true` 라면 뒤 두번째 조건을 실행(검사)하지 않음
		// 두번째 조건의 AND 문에서 (diff == maxDiff) 결과가 `false` 라면 `더_낮은_점수를_많이_맞힌_경우` 를 실행하지 않음
		if (
			(diff > maxDiff) ||
				(diff == maxDiff && 더_낮은_점수를_많이_맞힌_경우(ryanMap, answer))
		) {
			answer = ryanMap.clone();  // 현재 ryanMap 을 answer 로 복제
			maxDiff = diff;  // 최댓값 갱신
		}
	}

	// 1차 제출에서 최대 점수 차이의 경우의 수가 여러개인 케이스를 고려하지 않아 실패했습니다...
	// -> 최대 점수 차이가 여러개인 경우 낮은 점수를 더 많이 맞춘 경우의 수로 반환
	private static boolean 더_낮은_점수를_많이_맞힌_경우(int[] ryanMap, int[] answer) {
		for (int i = 10; i >= 0; i--) {
			if (ryanMap[i] > answer[i]) {
				return true;
			} else if (ryanMap[i] < answer[i]) {
				return false;
			}
		}
		return false;
	}
}
