/*
 * 프로그래머스 - 가장 먼 노드
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189
 */
package Lv_3.가장_먼_노드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        List<ArrayList<Integer>> edgeList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            edgeList.get(e[0]).add(e[1]);
            edgeList.get(e[1]).add(e[0]);
        }

        int[] map = new int[n + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});

        int max = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int node = poll[0];
            int count = poll[1];

            for (int nextNode : edgeList.get(node)) {
                if (nextNode == 1) continue;

                if (map[nextNode] == 0) {
                    map[nextNode] = count;
                    queue.add(new int[]{nextNode, count + 1});

                    if (count > max) {
                        answer = 1;
                        max = count;
                    } else if (count == max) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
