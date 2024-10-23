/*
 * 프로그래머스 - 피로도
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
package Lv_2.피로도;

class Solution {

	private int answer = 0;
	private int[][] dungeonMap;

	public int solution(int k, int[][] dungeons) {
		dungeonMap = dungeons;
		boolean[] visit = new boolean[dungeonMap.length];
		DFS(visit, k, 0);
		return answer;
	}

	public void DFS(boolean[] visit, int k, int count) {
		answer = Math.max(answer, count);

		for (int i = 0; i < dungeonMap.length; i++) {
			if (!visit[i] && dungeonMap[i][0] <= k) {
				visit[i] = true;
				DFS(visit, k - dungeonMap[i][1], count + 1);

				visit[i] = false;
			}
		}
	}
}
