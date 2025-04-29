/*
 * 프로그래머스 - 동굴 탐험
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/67260
 */
package Lv_4.동굴_탐험;

import java.util.*;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());

        for (int[] p : path) {
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }

        Map<Integer, Integer> orderMap = new HashMap<>();
        for (int[] o : order) {
            if (o[1] == 0) return false;  // 항상 0 부터 시작해야함

            orderMap.put(o[1], o[0]);
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        Map<Integer, Integer> prevMap = new HashMap<>();

        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            for (int linkNode : graph.get(currNode)) {
                if (visited[linkNode]) continue;

                if (orderMap.containsKey(linkNode)) {
                    int prevNode = orderMap.get(linkNode);

                    if (!visited[prevNode]) {
                        prevMap.put(prevNode, linkNode);
                        continue;
                    }
                }

                visited[linkNode] = true;
                queue.add(linkNode);
            }

            if (prevMap.containsKey(currNode)) {
                int nextNode = prevMap.get(currNode);
                queue.add(nextNode);

                visited[nextNode] = true;
                prevMap.remove(currNode);
            }
        }

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}
