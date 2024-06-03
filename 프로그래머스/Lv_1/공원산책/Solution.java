/*
 * 24/03/19
 *
 * 프로그래머스 - 공원 산책
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/172928
 */
package Lv_1.공원산책;

import java.util.HashMap;
import java.util.Map;

class Solution {

	// 시작 좌표 init
	static int startX = 0;
	static int startY = 0;

	public int[] solution(String[] park, String[] routes) {
		int height = park.length;  // 좌표 세로
		int weight = park[0].length();  // 좌표 길이

		// 배열 init
		char[][] arrayMap = new char[height][weight];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < weight; j++) {
				if (park[i].charAt(j) == 'S') {
					startX = i;
					startY = j;
				}
				arrayMap[i][j] = park[i].charAt(j);
			}
		}

		// 이동 규칙
		Map<String, int[]> moveMap = new HashMap<>();
		moveMap.put("E", new int[] {0, 1});
		moveMap.put("S", new int[] {1, 0});
		moveMap.put("W", new int[] {0, -1});
		moveMap.put("N", new int[] {-1, 0});

		for (String route : routes) {
			String[] temp = route.split(" ");

			int[] direct = moveMap.get(temp[0]);  // 이동 방향
			int count = Integer.parseInt(temp[1]);  // 이동 횟수

			moveAt(arrayMap, startX, startY, direct, count);
		}

		return new int[] {startX, startY};
	}

	private void moveAt(char[][] arrayMap, int nowX, int nowY, int[] direct, int count) {
		if (count == 0) {  // 종료 조건
			startX = nowX;
			startY = nowY;
			return;
		}

		int moveX = nowX + direct[0];
		int moveY = nowY + direct[1];

		if (moveX >= 0 && moveX < arrayMap.length &&
			moveY >= 0 && moveY < arrayMap[0].length &&
			arrayMap[moveX][moveY] != 'X') {
			moveAt(arrayMap, moveX, moveY, direct, count - 1);
		}
	}
}
