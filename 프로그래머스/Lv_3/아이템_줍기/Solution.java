/*
 * 프로그래머스 - 아이템 줍기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/87694
 */
package Lv_3.아이템_줍기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

	private static final int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
	private static final int[] dy = {1, -1, 0, 0};

	private int[][] map;
	private boolean[][] visited;

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int answer = 0;

		// 2배 스케일링
		map = new int[101][101];
		visited = new boolean[101][101];

		for (int[] rect : rectangle) {
			int leftX = rect[0] * 2;
			int leftY = rect[1] * 2;
			int rightX = rect[2] * 2;
			int rightY = rect[3] * 2;

			// 사각형의 외곽선을 1로 설정
			for (int i = leftX; i <= rightX; i++) {
				if (map[i][leftY] != 2) {
					map[i][leftY] = 1;
				}
				if (map[i][rightY] != 2) {
					map[i][rightY] = 1;
				}
			}
			for (int i = leftY; i <= rightY; i++) {
				if (map[leftX][i] != 2) {
					map[leftX][i] = 1;
				}
				if (map[rightX][i] != 2) {
					map[rightX][i] = 1;
				}
			}

			// 사각형 내부를 2로 채우기 (이동 불가능 영역)
			for (int i = leftX + 1; i < rightX; i++) {
				for (int j = leftY + 1; j < rightY; j++) {
					map[i][j] = 2;
				}
			}
		}

		characterX *= 2;
		characterY *= 2;
		itemX *= 2;
		itemY *= 2;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {characterX, characterY, 0});

		visited[characterX][characterY] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currX = current[0];
			int currY = current[1];
			int count = current[2];

			if (currX == itemX && currY == itemY) {
				answer = count / 2; // 2배 스케일을 적용했으므로 2로 나눔
				break;
			}

			// 상하좌우로 이동
			for (int i = 0; i < 4; i++) {
				int nextX = currX + dx[i];
				int nextY = currY + dy[i];

				if (
					nextX >= 0 && nextX <= 100
						&& nextY >= 0 && nextY <= 100
						&& map[nextX][nextY] == 1
						&& !visited[nextX][nextY]
				) {
					visited[nextX][nextY] = true;
					queue.add(new int[] {nextX, nextY, count + 1});
				}
			}
		}
		return answer;
	}
}

