/*
 * 프로그래머스 - 미로 탈출
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/81304
 */
package Lv_4.미로_탈출;

import java.util.*;

class Solution {

    private Map<Integer, Integer> trapMap;

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        List<List<int[]>> map = new ArrayList<>();
        List<List<int[]>> reverseMap = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
            reverseMap.add(new ArrayList<>());
        }

        trapMap = new HashMap<>();
        for (int i = 0; i < traps.length; i++) trapMap.put(traps[i], i);

        for (int[] road : roads) {
            map.get(road[0]).add(new int[]{road[1], road[2]});
            reverseMap.get(road[1]).add(new int[]{road[0], road[2]});
        }

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[]{start, 0, 0});

        boolean[][] visit = new boolean[n + 1][1 << traps.length];  // trap idx로 on/off

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int node = poll[0];
            int cost = poll[1];
            int state = poll[2];

            if (node == end) return cost;

            if (visit[node][state]) continue;

            visit[node][state] = true;

            boolean isReverse = checkReverse(node, state);
            for (int[] next : map.get(node)) {
                int nextNode = next[0];

                boolean isNextReverse = checkReverse(nextNode, state);

                if (isReverse == isNextReverse) {
                    queue.add(new int[]{nextNode, cost + next[1], nextState(nextNode, state)});
                }
            }

            for (int[] next : reverseMap.get(node)) {
                int nextNode = next[0];

                boolean isNextReverse = checkReverse(nextNode, state);

                if (isReverse ^ isNextReverse) {
                    queue.add(new int[]{nextNode, cost + next[1], nextState(nextNode, state)});
                }
            }
        }

        return -1;
    }

    // 4개의 트랩이 0001 이고 현재 노드가 트랩의 idx값이 2인 노드인 경우 -> "0001 & 0100 = 0000" :: 3번째 트랩(현재 노드) 꺼져있음
    private boolean checkReverse(int node, int state) {
        if (!trapMap.containsKey(node)) return false;

        int trapIdxBit = trapMap.get(node);
        return (state & (1 << trapIdxBit)) != 0;
    }

    // 4개의 트랩이 0001 이고 idx가 2인 트랩에 걸릴경우 -> "0001 ^ 0100 = 0101" :: 3번째 트랩 켜짐
    private int nextState(int node, int state) {
        if (!trapMap.containsKey(node)) return state;

        int trapIdxBit = trapMap.get(node);
        return state ^ (1 << trapIdxBit);
    }
}
