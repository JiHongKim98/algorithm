/*
 * 프로그래머스 - 양과 늑대
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/92343
 */
package Lv_3.양과_늑대;

import java.util.ArrayList;

class Solution {

    private int answer;
    private int[] info;
    private ArrayList<Integer>[] map;
    private boolean[][][] visit;

    public int solution(int[] info, int[][] edges) {
        this.info = info;

        map = new ArrayList[info.length];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<Integer>();
        }

        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        visit = new boolean[info.length][info.length + 1][info.length + 1];

        dfs(0, 0, 0);

        return answer;
    }

    private void dfs(int sheep, int wolf, int node) {
        if (info[node] == 0) sheep++;
        else if (info[node] == 1) wolf++;

        if (sheep <= wolf) return;

        answer = Math.max(answer, sheep);

        for (int i = 0; i < map[node].size(); i++) {
            int nextNode = map[node].get(i);

            if (!visit[nextNode][sheep][wolf]) {
                int memory = info[node];

                info[node] = -1;
                visit[nextNode][sheep][wolf] = true;

                dfs(sheep, wolf, nextNode);

                info[node] = memory;
                visit[nextNode][sheep][wolf] = false;
            }
        }
    }
}
