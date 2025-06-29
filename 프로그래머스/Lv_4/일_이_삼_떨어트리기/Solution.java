/*
 * 프로그래머스 - 1,2,3 떨어트리기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/150364
 */
package Lv_4.일_이_삼_떨어트리기;

import java.util.*;

class Solution {
    public int[] solution(int[][] edges, int[] target) {
        List<Integer>[] graph = new ArrayList[edges.length + 1];
        for (int i = 0; i <= edges.length; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) graph[edge[0] - 1].add(edge[1] - 1);

        for (int i = 0; i <= edges.length; i++) Collections.sort(graph[i]);

        int leafNodeCount = 0;
        for (int i = 0; i <= edges.length; i++) if (graph[i].isEmpty() && target[i] > 0) leafNodeCount++;

        int[] count = new int[edges.length + 1];
        int[] visitCount = new int[edges.length + 1];
        boolean[] visit = new boolean[edges.length + 1];

        Queue<Integer> queue = new LinkedList<>();

        while (leafNodeCount > 0) {
            int node = 0;

            while (!graph[node].isEmpty()) node = graph[node].get(visitCount[node]++ % graph[node].size());

            count[node]++;
            queue.add(node);

            if (count[node] > target[node]) return new int[]{-1};

            if (!visit[node] && target[node] <= 3 * count[node]) {
                visit[node] = true;
                leafNodeCount--;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int leaf : queue) {
            count[leaf]--;

            for (int i = 1; i <= 3; i++) {
                if (target[leaf] - i >= count[leaf] && target[leaf] - i <= 3 * count[leaf]) {
                    answer.add(i);
                    target[leaf] -= i;
                    break;
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
