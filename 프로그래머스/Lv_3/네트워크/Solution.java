package Lv_3.네트워크;

class Solution {

	private int maxDepth;
	private int[][] comMap;
	private boolean[] visit;

	public int solution(int n, int[][] computers) {
		int answer = 0;

		maxDepth = n;
		comMap = computers;
		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				DFS(i, 0);
				answer++;
			}
		}

		return answer;
	}

	private void DFS(int node, int count) {
		visit[node] = true;

		if (count == maxDepth) {
			return;
		}

		for (int i = 0; i < maxDepth; i++) {
			if (!visit[i] && comMap[node][i] == 1) {
				DFS(i, count + 1);
			}
		}
	}
}
