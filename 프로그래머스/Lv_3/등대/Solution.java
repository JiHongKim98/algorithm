/*
 * 프로그래머스 - 등대
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/133500
 */
package Lv_3.등대;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private boolean[] visit;
    private static Map<Integer, List<Integer>> graph = new HashMap<>();

    public int solution(int n, int[][] lighthouse) {
        for (int[] l : lighthouse) {
            graph.computeIfAbsent(l[0], k -> new ArrayList<>()).add(l[1]);
            graph.computeIfAbsent(l[1], k -> new ArrayList<>()).add(l[0]);
        }

        visit = new boolean[n + 1];

        int[] answer = dfs(1);

        return Math.min(answer[0], answer[1]);
    }

    private int[] dfs(int node) {
        visit[node] = true;

        int[] curr = new int[]{0, 1};

        for (int nextNode : graph.get(node)) {
            if (visit[nextNode]) continue;

            int[] next = dfs(nextNode);

            curr[0] += next[1];
            curr[1] += Math.min(next[0], next[1]);
        }

        return curr;
    }
}
