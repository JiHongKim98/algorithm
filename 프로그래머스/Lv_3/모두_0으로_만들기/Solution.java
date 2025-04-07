/*
 * 프로그래머스 - 모두 0으로 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/76503
 */
package Lv_3.모두_0으로_만들기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public long solution(int[] a, int[][] edges) {
        int[] degreeMap = new int[a.length];
        long[] map = new long[a.length];
        boolean[] visit = new boolean[a.length];
        List<List<Integer>> graph = new ArrayList<>();

        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            map[i] = a[i];
            graph.add(new ArrayList<>());
        }

        if (sum != 0) return -1;

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degreeMap[edge[0]]++;
            degreeMap[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degreeMap.length; i++) {
            if (degreeMap[i] == 1) queue.add(i);
        }

        long answer = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visit[node] = true;

            for (int nextNode : graph.get(node)) {
                if (visit[nextNode]) continue;

                degreeMap[nextNode]--;

                map[nextNode] += map[node];
                answer += Math.abs(map[node]);

                if (degreeMap[nextNode] == 1) queue.add(nextNode);
            }
        }

        return answer;
    }
}
