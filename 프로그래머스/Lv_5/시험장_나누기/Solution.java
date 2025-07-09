/*
 * 프로그래머스 - 시험장 나누기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/81305
 */
package Lv_5.시험장_나누기;

import java.util.Arrays;

class Solution {

    private int cutCount;
    private Node rootNode;

    public int solution(int k, int[] num, int[][] links) {
        Node[] nodes = new Node[num.length];
        for (int i = 0; i < num.length; i++) nodes[i] = new Node(num[i]);

        int[] parents = new int[num.length];
        Arrays.fill(parents, -1);
        for (int i = 0; i < links.length; i++) {
            if (links[i][0] != -1) {
                nodes[i].c1 = nodes[links[i][0]];
                parents[links[i][0]] = i;
            }
            if (links[i][1] != -1) {
                nodes[i].c2 = nodes[links[i][1]];
                parents[links[i][1]] = i;
            }
        }

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) {
                rootNode = nodes[i];
                break;
            }
        }

        int min = 0;
        int max = 0;
        for (int n : num) {
            min = Math.max(min, n);
            max += n;
        }

        while (min <= max) {
            cutCount = 0;

            int mid = (min + max) / 2;

            rootNode.cut(mid);

            if (cutCount < k) max = mid - 1;
            else min = mid + 1;
        }

        return min;
    }

    class Node {
        Node c1, c2;
        int count;

        public Node(int count) {
            this.count = count;
        }

        public int cut(int max) {
            int c1Sum = 0;
            if (c1 != null) c1Sum = c1.cut(max);

            int c2Sum = 0;
            if (c2 != null) c2Sum = c2.cut(max);

            if (c1Sum + c2Sum + count <= max) {
                return c1Sum + c2Sum + count;
            } else if (Math.min(c1Sum, c2Sum) + count <= max) {
                cutCount += 1;
                return Math.min(c1Sum, c2Sum) + count;
            } else {
                cutCount += 2;
                return count;
            }
        }
    }
}
