/*
 * 프로그래머스 - 방의 개수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/49190
 */
package Lv_5.방의_개수;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
    private int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {
        Map<Node, List<Node>> graph = new HashMap<>();
        Node currNode = new Node(0, 0);
        graph.put(currNode, new ArrayList<>());

        int answer = 0;

        for (int i = 0; i < arrows.length * 2; i++) {
            int dis = arrows[i / 2];
            int nextX = currNode.x + dx[dis];
            int nextY = currNode.y + dy[dis];

            Node nextNode = new Node(nextX, nextY);

            if (!graph.containsKey(nextNode)) {
                graph.computeIfAbsent(nextNode, k -> new ArrayList<>()).add(currNode);
                graph.get(currNode).add(nextNode);
            } else if (!graph.get(nextNode).contains(currNode)) {
                graph.get(nextNode).add(currNode);
                graph.get(currNode).add(nextNode);
                answer++;
            }

            currNode = nextNode;
        }

        return answer;
    }

    class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Node cast = (Node) o;
            return x == cast.x && y == cast.y;
        }

        @Override
        public int hashCode() {
            return x * 100019 + y;
        }
    }
}
