/*
 * 프로그래머스 - 섬 연결하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861
 */
package Lv_3.섬_연결하기;

import java.util.Arrays;

class Solution {

    private static int[] parentMap;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parentMap = new int[n];
        for (int i = 0; i < n; i++) {
            parentMap[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for (int[] cost : costs) {
            int node1 = cost[0];
            int node2 = cost[1];

            int node1Parent = findParent(node1);
            int node2Parent = findParent(node2);

            if (node1Parent != node2Parent) {
                parentMap[node1Parent] = node2Parent;
                answer += cost[2];
            }
        }

        return answer;
    }

    private int findParent(int node) {
        if (parentMap[node] == node) {
            return node;
        }
        return parentMap[node] = findParent(parentMap[node]);
    }
}
