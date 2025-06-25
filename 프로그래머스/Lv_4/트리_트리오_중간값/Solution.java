/*
 * 프로그래머스 - 트리 트리오 중간값
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/68937
 */
package Lv_4.트리_트리오_중간값;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    private int n;
    private List<Integer>[] graph;

    public int solution(int n, int[][] edges) {
        this.n = n;

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] dist1 = getDist(1);

        int aNode = getNode(dist1);
        int[] distA = getDist(aNode);

        int bNode = getNode(distA);
        int[] distB = getDist(bNode);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i == aNode || i == bNode) continue;

            int maxDist = Math.max(distA[i], distB[i]);
            answer = Math.max(answer, maxDist);
        }

        return answer;
    }

    private int[] getDist(int node) {
        int[] dist = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        boolean[] visit = new boolean[n + 1];
        visit[node] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int next : graph[poll]) {
                if (visit[next]) continue;

                visit[next] = true;
                dist[next] = dist[poll] + 1;
                queue.add(next);
            }
        }
        return dist;
    }

    private int getNode(int[] dist) {  // 가장 먼 노드 가져오기
        int node = 1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > dist[node]) node = i;
        }
        return node;
    }
}
