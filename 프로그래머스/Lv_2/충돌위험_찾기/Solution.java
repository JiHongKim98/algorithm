/*
 * 프로그래머스 - 충돌위험 찾기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/340211
 */
package Lv_2.충돌위험_찾기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

	private int answer;
	private int robotCount;
	private Queue<int[]>[] memo;

	public int solution(int[][] points, int[][] routes) {
		robotCount = routes.length;
		memo = new LinkedList[robotCount];
		for (int i = 0; i < robotCount; i++) {
			memo[i] = new LinkedList<>();
		}

		좌표_계산_및_큐에_저장(points, routes);
		answer = 좌표_순회_중복_계산();

		return answer;
	}

	private void 좌표_계산_및_큐에_저장(int[][] points, int[][] routes) {
		for (int i = 0; i < robotCount; i++) {

			int totalPoint = routes[i].length;
			int startPoint = routes[i][0] - 1;

			int nowX = points[startPoint][0];
			int nowY = points[startPoint][1];

			memo[i].add(new int[] {nowX, nowY});

			for (int j = 1; j < totalPoint; j++) {
				int nowTarget = routes[i][j];

				int targetX = points[nowTarget - 1][0];
				int targetY = points[nowTarget - 1][1];

				while (targetX - nowX != 0) {
					int moveX = targetX - nowX;

					if (moveX < 0) {
						nowX--;
					} else {
						nowX++;
					}

					memo[i].add(new int[] {nowX, nowY});
				}

				while (targetY - nowY != 0) {
					int moveY = targetY - nowY;

					if (moveY < 0) {
						nowY--;
					} else {
						nowY++;
					}

					memo[i].add(new int[] {nowX, nowY});
				}
			}
		}
	}

	private int 좌표_순회_중복_계산() {
		int finishRobotCount = 0;

		while (finishRobotCount != robotCount) {
			finishRobotCount = 0;
			int[][] map = new int[101][101];

			for (int i = 0; i < robotCount; i++) {
				if (memo[i].isEmpty()) {
					finishRobotCount++;
					continue;
				}

				int[] currentXY = memo[i].poll();
				map[currentXY[0]][currentXY[1]]++;
			}

			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					if (map[i][j] >= 2) {
						answer++;
					}
				}
			}
		}
		return answer;
	}
}
