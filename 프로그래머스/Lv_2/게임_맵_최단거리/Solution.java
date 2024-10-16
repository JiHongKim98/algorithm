/*
 * 프로그래머스 - 충돌위험 찾기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
package Lv_2.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

	private final int[] dx = {0, 0, 1, -1};
	private final int[] dy = {1, -1, 0, 0};

	public int solution(int[][] maps) {
		int maxX = maps.length;
		int maxY = maps[0].length;

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 1));

		boolean[][] visit = new boolean[maxX][maxY];
		visit[0][0] = true;

		while (!queue.isEmpty()) {
			Node nowNode = queue.poll();

			if (nowNode.getX() == maxX - 1 && nowNode.getY() == maxY - 1) {
				return nowNode.getCount();
			}

			for (int i = 0; i < 4; i++) {
				int nowX = nowNode.getX() + dx[i];
				int nowY = nowNode.getY() + dy[i];

				if (nowX >= 0 && nowX < maxX && nowY >= 0 && nowY < maxY) {

					if (!visit[nowX][nowY] && maps[nowX][nowY] == 1) {
						visit[nowX][nowY] = true;
						int count = nowNode.getCount();
						queue.add(new Node(nowNode.getX() + dx[i], nowNode.getY() + dy[i], count + 1));
					}
				}
			}
		}
		return -1;
	}

	// Nested
	private class Node {

		private int x;
		private int y;
		private int count;

		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getCount() {
			return count;
		}
	}
}
