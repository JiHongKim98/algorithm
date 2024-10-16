/*
 * 프로그래머스 - 최소직사각형
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
package Lv_1.최소직사각형;

class Solution {

	public int solution(int[][] sizes) {
		int[][] map = new int[sizes.length][sizes[0].length];

		for (int i = 0; i < sizes.length; i++) {
			int x = sizes[i][0];
			int y = sizes[i][1];
			if (x > y) {
				map[i][0] = x;
				map[i][1] = y;
			} else {
				map[i][0] = y;
				map[i][1] = x;
			}
		}

		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;

		for (int i = 0; i < sizes.length; i++) {
			maxX = Math.max(map[i][0], maxX);
			maxY = Math.max(map[i][1], maxY);
		}

		return maxX * maxY;
	}
}
