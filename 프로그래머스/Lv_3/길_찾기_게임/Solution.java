/*
 * 프로그래머스 - 길 찾기 게임
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42892
 */
package Lv_3.길_찾기_게임;

import java.util.Arrays;

class Solution {

    private int idx;
    private int[][] answer;

    public int[][] solution(int[][] nodeinfo) {
        Node[] nodeMap = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodeMap[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodeMap, (o1, o2) -> o2.y - o1.y);

        Node rootNode = nodeMap[0];
        for (int i = 1; i < nodeMap.length; i++) {
            appendNode(rootNode, nodeMap[i]);
        }

        answer = new int[2][nodeMap.length];

        idx = 0;
        preOrder(rootNode);

        idx = 0;
        postOrder(rootNode);

        return answer;
    }

    private void appendNode(Node parent, Node target) {
        if (parent.x > target.x) {
            if (parent.left == null) parent.left = target;
            else appendNode(parent.left, target);
        }

        if (parent.x < target.x) {
            if (parent.right == null) parent.right = target;
            else appendNode(parent.right, target);
        }
    }

    public void preOrder(Node root) {
        answer[0][idx++] = root.num;

        if (root.left != null) preOrder(root.left);
        if (root.right != null) preOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root.left != null) postOrder(root.left);
        if (root.right != null) postOrder(root.right);

        answer[1][idx++] = root.num;
    }

    private class Node {
        int num;  // 노드 번호
        int x;  // x 좌표
        int y;  // y 좌표
        Node left;  // 왼쪽 자식 노드
        Node right;  // 오른쪽 자식 노드

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
}
