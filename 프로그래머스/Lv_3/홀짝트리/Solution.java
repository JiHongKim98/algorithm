/*
 * 프로그래머스 - 홀짝트리
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/388354
 */
package Lv_3.홀짝트리;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private Map<Integer, List<Integer>> graph;
    private Map<Integer, Integer> nodeColor;  // 0 : 홀짝 | 1: 역홀짝 | -INF: 미탐색

    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];

        graph = new HashMap<>();
        nodeColor = new HashMap<>();

        for (int node : nodes) {
            graph.put(node, new ArrayList<>());
            nodeColor.put(node, Integer.MIN_VALUE);
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int node : nodes) {
            if (nodeColor.get(node) != Integer.MIN_VALUE) continue;

            int[] colorMap = new int[2];
            DFS(node, 0, colorMap);

            if (colorMap[0] == 0) {
                if (colorMap[1] == 2) answer[0]++;
                answer[1]++;
            } else if (colorMap[1] == 0) {
                if (colorMap[0] == 2) answer[1]++;
                answer[0]++;
            } else if (colorMap[0] == 2 && nodeColor.get(node) == 0) {
                answer[1]++;
            } else if (colorMap[1] == 2 && nodeColor.get(node) == 1) {
                answer[0]++;
            }
        }

        return answer;
    }

    private void DFS(int currNode, int prevNode, int[] colorMap) {
        int nodes = 0;
        for (int nextNode : graph.get(currNode)) {
            if (nextNode == prevNode) continue;

            nodes++;
            DFS(nextNode, currNode, colorMap);
        }

        int color = (currNode % 2 + nodes % 2) % 2;

        colorMap[color]++;
        nodeColor.put(currNode, color);
    }
}
