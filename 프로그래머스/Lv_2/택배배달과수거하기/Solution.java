/*
 * 24/06/24
 *
 * 프로그래머스 - 택배 배달과 수거하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/150369
 */
package Lv_2.택배배달과수거하기;

public class Solution {

	// 최대 적재량,   주택의 수,   배달해야할 배열,   수거해야할 배열
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		// 배달과 수거를 누적해서 저장
		int 배달물품수 = 0;
		int 수거물품수 = 0;

		// 배열을 역순으로 처리 -> 가장 멀리 있는 것 집부터 처리
		for (int i = n - 1; i >= 0; i--) {
			배달물품수 += deliveries[i];  // 현재 집에서 배달받아야 할 물품의 누적
			수거물품수 += pickups[i];  // 현재 집에서 수거되야 할 물품을 누적

			// 배달 물품 or 수거할 물품이 남아 있는 동안 반복
			while (
				배달물품수 > 0 ||
					수거물품수 > 0
			) {
				배달물품수 -= cap;  // 트럭 용량(n)만큼 물품 배달
				수거물품수 -= cap;  // 트럭 용량(n)만큼 물품 수거

				answer += (i + 1) * 2;  // 현재 위치까지의 왕복 거리 (물류창고 <-> 현재 위치)
			}
		}

		return answer;
	}
}
