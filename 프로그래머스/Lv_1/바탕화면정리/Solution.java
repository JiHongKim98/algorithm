/*
 * 24/03/19
 *
 * 프로그래머스 - 바탕화면 정리
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/161990
 */
package Lv_1.바탕화면정리;

class Solution {
	public int[] solution(String[] wallpaper) {

		int h = wallpaper.length;
		int w = wallpaper[0].length();

		// 시작점
		int startX = Integer.MAX_VALUE;
		int startY = Integer.MAX_VALUE;

		// 끝점
		int endX = Integer.MIN_VALUE;
		int endY = Integer.MIN_VALUE;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (wallpaper[i].charAt(j) == '#') {

					// 시작점의 X 좌표는 x 좌표 기준 가장 적은 수
					if (startX > i)
						startX = i;

					// 시작점의 Y 좌표는 y 좌표 기준 가장 적은 수
					if (startY > j)
						startY = j;

					// 종료점의 X 좌표는 x 좌표 기준 가장 큰 수 + 1
					if (endX < i)
						endX = i;

					// 종료점의 Y 좌표는 y 좌표 기준 가장 큰 수 + 1
					if (endY < j)
						endY = j;
				}
			}
		}

		return new int[] {startX, startY, endX + 1, endY + 1};
	}
}

/*
 * NOTE:
 * 다른 사람들은
 *
 * if (startX > i) startX = i;
 * if (endX < i) endX = i;
 *
 * 이렇게 if문을 사용하는 대신 Math 를 많이 사용함.
 *
 * ex)
 *
 * startX = Math.min(startX, i);
 * endX = Math.max(endX, i);
 */
