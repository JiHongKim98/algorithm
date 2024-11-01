/*
 * 프로그래머스 - 정수 삼각형
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
package Lv_3.정수_삼각형;

class Solution {

	public int solution(int[][] triangle) {

		for (int i = triangle.length - 1; i >= 0; i--) {
			for (int j = 0; j < triangle[i].length - 1; j++) {
				int max = Math.max(triangle[i][j], triangle[i][j + 1]);
				triangle[i - 1][j] += max;
			}
		}

		return triangle[0][0];
	}
}
