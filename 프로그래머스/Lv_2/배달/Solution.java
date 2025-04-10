/*
 * 프로그래머스 - 배달
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12978
 */
package Lv_2.배달;

import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        Map<Integer, List<Node>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] r : road) {
            map.get(r[0]).add(new Node(r[1], r[2]));
            map.get(r[1]).add(new Node(r[0], r[2]));
        }

        int[] weightMap = new int[N + 1];
        Arrays.fill(weightMap, Integer.MAX_VALUE);
        weightMap[1] = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.weight > weightMap[poll.link]) continue;

            for (Node next : map.get(poll.link)) {
                int currWeight = poll.weight + next.weight;

                if (currWeight < weightMap[next.link]) {
                    weightMap[next.link] = currWeight;
                    queue.add(new Node(next.link, currWeight));
                }
            }
        }

        for (int weight : weightMap) {
            if (weight <= K) answer++;
        }

        return answer;
    }

    class Node {
        int link;
        int weight;

        public Node(int link, int weight) {
            this.link = link;
            this.weight = weight;
        }
    }
}
