/*
 * 프로그래머스 - 전력망을 둘로 나누기

 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
package Lv_2.전력망을_둘로_나누기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;

		for (int i = 0; i < wires.length; i++) {
			List<Node> list = new ArrayList<>();
			for (int j = 0; j <= n; j++) {
				list.add(new Node(j));
			}

			for (int j = 0; j < wires.length; j++) {
				if (i == j)
					continue;
				Node node1 = list.get(wires[j][0]);
				Node node2 = list.get(wires[j][1]);
				node1.updateEdge(node2);
				node2.updateEdge(node1);
			}

			int count1 = BFS(list, wires[i][0], n);
			int count2 = n - count1;

			answer = Math.min(answer, Math.abs(count1 - count2));
		}

		return answer;
	}

	private int BFS(List<Node> list, int startIdx, int n) {
		boolean[] visit = new boolean[n + 1];

		Queue<Node> queue = new LinkedList<>();
		queue.add(list.get(startIdx));
		visit[startIdx] = true;

		int count = 0;
		while (!queue.isEmpty()) {
			Node nowNode = queue.poll();
			count++;

			for (Node neighbor : nowNode.edges) {
				if (!visit[neighbor.idx]) {
					visit[neighbor.idx] = true;
					queue.add(neighbor);
				}
			}
		}
		return count;
	}

	// Node 클래스 정의
	private class Node {
		int idx;
		List<Node> edges = new ArrayList<>();

		Node(int idx) {
			this.idx = idx;
		}

		void updateEdge(Node node) {
			edges.add(node);
		}
	}
}
