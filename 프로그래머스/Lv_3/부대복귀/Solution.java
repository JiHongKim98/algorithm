/*
 * 프로그래머스 - 부대복귀
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/132266
 */
package Lv_3.부대복귀;

import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] nodeMap = new int[n + 1];
        Arrays.fill(nodeMap, -1);
        nodeMap[destination] = 0;

        List<ArrayList<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{destination, 1});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int node = poll[0];
            int count = poll[1];

            for (int nextNode : map.get(node)) {
                if (nodeMap[nextNode] == -1) {
                    nodeMap[nextNode] = count;
                    queue.add(new int[]{nextNode, count + 1});
                }
            }
        }

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = nodeMap[sources[i]];
        }
        return answer;
    }
}
