/*
 * 프로그래머스 - 빠른 이동
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/214294
 */
package Lv_5.빠른_이동;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    private int idx = 1;
    private int sccCount = 0;
    private int[] low, disc, sccIds;

    private List<Integer>[] graph;

    public int solution(int n, int[][] roads) {
        low = new int[n + 1];
        disc = new int[n + 1];
        sccIds = new int[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : roads) graph[edge[0]].add(edge[1]);

        for (int i = 1; i <= n; i++) {
            boolean[] visit = new boolean[n + 1];
            if (disc[i] == 0) tarjan(i, visit, new Stack<>());
        }

        List<Integer>[] DAG = new ArrayList[sccCount + 1];
        for (int i = 1; i <= sccCount; i++) DAG[i] = new ArrayList<>();
        for (int u = 1; u <= n; u++) {
            for (int v : graph[u]) {
                if (sccIds[u] != sccIds[v]) {
                    DAG[sccIds[u]].add(sccIds[v]);
                }
            }
        }

        List<Integer>[] reaches = new ArrayList[sccCount + 1];
        for (int i = 1; i <= sccCount; i++) {
            reaches[i] = new ArrayList<>();

            boolean[] visit = new boolean[sccCount + 1];
            visit[i] = true;

            Stack<Integer> stack = new Stack<>();
            stack.push(i);

            while (!stack.isEmpty()) {
                int curr = stack.pop();

                for (int next : DAG[curr]) {
                    if (!visit[next]) {
                        visit[next] = true;
                        stack.push(next);
                    }
                }
            }

            for (int j = 1; j <= sccCount; j++) {
                if (i == j) continue;

                if (visit[j]) reaches[i].add(j);
            }
        }

        int matchCount = 0;
        int[] match = new int[sccCount + 1];
        for (int i = 1; i <= sccCount; i++) {
            boolean[] visit = new boolean[sccCount + 1];
            if (isMatch(i, match, reaches, visit)) matchCount++;
        }

        return sccCount - matchCount - 1;
    }

    private void tarjan(int u, boolean[] visit, Stack<Integer> stack) {
        disc[u] = low[u] = idx++;

        stack.push(u);
        visit[u] = true;

        for (int v : graph[u]) {
            if (disc[v] == 0) {
                tarjan(v, visit, stack);
                low[u] = Math.min(low[u], low[v]);
            } else if (visit[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (low[u] == disc[u]) {
            sccCount++;

            while (true) {
                int node = stack.pop();
                visit[node] = false;
                sccIds[node] = sccCount;

                if (node == u) break;
            }
        }
    }

    private boolean isMatch(int u, int[] match, List<Integer>[] dag, boolean[] visit) {
        for (int v : dag[u]) {
            if (visit[v]) continue;
            visit[v] = true;

            if (match[v] == 0 || isMatch(match[v], match, dag, visit)) {
                match[v] = u;
                return true;
            }
        }
        return false;
    }
}
