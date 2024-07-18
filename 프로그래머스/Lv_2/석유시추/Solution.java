/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250136
 */
package Lv_2.석유시추;

// BFS 로 완전 탐색해서 석유의 양을 구하기
//  -> BFS시 상하좌우를 탐색해야함
//  -> 중복 탐색을 제거하기 위해서는 visit 배열을 사용
// 각 열에 대한 배열을 만들어 석유의 양을 기입

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

	private int[][] landMap;
	private int maxRows;
	private int maxCols;
	private int[] oilAmountInColumn;

	private final int[] dx = {-1, 0, 1, 0};
	private final int[] dy = {0, 1, 0, -1};

	public int solution(int[][] land) {
		int answer = 0;

		landMap = land;
		maxRows = land.length;
		maxCols = land[0].length;
		oilAmountInColumn = new int[maxCols];

		boolean[][] visitMap = new boolean[maxRows][maxCols];

		// BFS로 석유양을 탐색
		for (int i = 0; i < maxRows; i++) {
			for (int j = 0; j < maxCols; j++) {

				if (!visitMap[i][j] && landMap[i][j] == 1) {
					BFS(i, j, visitMap);
				}
			}
		}

		// 가장 많은 석유를 뽑을 수 있는 열 찾기
		for (int j = 0; j < maxCols; j++) {
			answer = Math.max(answer, oilAmountInColumn[j]);
		}

		return answer;
	}

	private void BFS(int x, int y, boolean[][] visitMap) {
		Queue<int[]> queue = new LinkedList<>();
		visitMap[x][y] = true;
		queue.add(new int[] {x, y});

		int oilCount = 1;
		Set<Integer> colsLocation = new LinkedHashSet<>();

		while (!queue.isEmpty()) {
			int[] nowLand = queue.poll();
			colsLocation.add(nowLand[1]);

			for (int k = 0; k < 4; k++) {
				int nx = nowLand[0] + dx[k];
				int ny = nowLand[1] + dy[k];

				if (nx < 0 || nx >= maxRows ||
					ny < 0 || ny >= maxCols)
					continue;

				if (!visitMap[nx][ny] && landMap[nx][ny] == 1) {
					queue.add(new int[] {nx, ny});
					visitMap[nx][ny] = true;
					oilCount++;
				}
			}
		}

		for (int col : colsLocation) {
			oilAmountInColumn[col] += oilCount;
		}
	}
}
