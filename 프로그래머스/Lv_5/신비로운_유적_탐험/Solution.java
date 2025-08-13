/*
 * 프로그래머스 - 신비로운 유적 탐험
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1834
 */
package Lv_5.신비로운_유적_탐험;

import java.util.*;

class Solution {

    private List<Integer>[] childTreeA;
    private List<Integer>[] childTreeB;
    private int[][] memo;

    public int solution(int nodeCountA, int[][] edgesA, int nodeCountB, int[][] edgesB) {
        childTreeA = initChildTree(nodeCountA, edgesA);
        childTreeB = initChildTree(nodeCountB, edgesB);

        memo = new int[nodeCountA + 1][nodeCountB + 1];
        for (int i = 0; i <= nodeCountA; i++) Arrays.fill(memo[i], -1);

        return DFS(1, 1);
    }

    private List<Integer>[] initChildTree(int nodeCount, int[][] edges) {
        List<Integer>[] adjacencyList = new ArrayList[nodeCount + 1];
        for (int i = 0; i <= nodeCount; i++) adjacencyList[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }

        List<Integer>[] childrenList = new ArrayList[nodeCount + 1];
        for (int i = 0; i <= nodeCount; i++) childrenList[i] = new ArrayList<>();

        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{1, 0});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int currentNode = current[0];
            int parentNode = current[1];

            for (int neighbor : adjacencyList[currentNode]) {
                if (neighbor == parentNode) continue;

                childrenList[currentNode].add(neighbor);
                stack.push(new int[]{neighbor, currentNode});
            }
        }
        return childrenList;
    }

    private int DFS(int nodeA, int nodeB) {
        if (memo[nodeA][nodeB] != -1) return memo[nodeA][nodeB];

        List<Integer> childrenA = childTreeA[nodeA];
        List<Integer> childrenB = childTreeB[nodeB];

        if (childrenA.isEmpty() || childrenB.isEmpty()) return memo[nodeA][nodeB] = 1;

        int m = childrenA.size();
        int n = childrenB.size();
        int[][] similarityMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            int childA = childrenA.get(i);
            for (int j = 0; j < n; j++) {
                int childB = childrenB.get(j);
                similarityMatrix[i][j] = DFS(childA, childB);
            }
        }

        return memo[nodeA][nodeB] = 1 + maxAssignment(similarityMatrix);
    }

    private int maxAssignment(int[][] weights) {
        int rowCount = weights.length;
        int colCount = (rowCount == 0 ? 0 : weights[0].length);
        if (rowCount == 0 || colCount == 0) return 0;

        int maxWeight = 0;
        for (int[] row : weights) {
            for (int w : row) maxWeight = Math.max(maxWeight, w);
        }

        int[][] costMap;
        if (rowCount <= colCount) {
            costMap = new int[rowCount][colCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    costMap[i][j] = maxWeight - weights[i][j];
                }
            }
        } else {
            int[][] transposed = new int[colCount][rowCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    transposed[j][i] = weights[i][j];
                }
            }
            int tmp = rowCount;
            rowCount = colCount;
            colCount = tmp;
            costMap = new int[rowCount][colCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    costMap[i][j] = maxWeight - transposed[i][j];
                }
            }
        }

        int[] cols = new int[colCount + 1];
        int[] prevCols = new int[colCount + 1];
        int[] potRow = new int[rowCount + 1];
        int[] potCol = new int[colCount + 1];

        for (int i = 1; i <= rowCount; i++) {
            cols[0] = i;

            int[] minMap = new int[colCount + 1];
            Arrays.fill(minMap, Integer.MAX_VALUE);

            boolean[] visit = new boolean[colCount + 1];

            int currCol = 0;
            while (true) {
                visit[currCol] = true;

                int matchedRow = cols[currCol];
                int delta = Integer.MAX_VALUE;
                int nextCol = 0;

                for (int j = 1; j <= colCount; j++) {
                    if (visit[j]) continue;

                    int reduceCost = costMap[matchedRow - 1][j - 1] - potRow[matchedRow] - potCol[j];
                    if (reduceCost < minMap[j]) {
                        minMap[j] = reduceCost;
                        prevCols[j] = currCol;
                    }
                    if (minMap[j] < delta) {
                        delta = minMap[j];
                        nextCol = j;
                    }
                }

                for (int j = 0; j <= colCount; j++) {
                    if (visit[j]) {
                        potRow[cols[j]] += delta;
                        potCol[j] -= delta;
                    } else {
                        minMap[j] -= delta;
                    }
                }

                currCol = nextCol;
                if (cols[currCol] == 0) break;
            }

            while (currCol != 0) {
                int prevCol = prevCols[currCol];
                cols[currCol] = cols[prevCol];
                currCol = prevCol;
            }
        }

        int sum = 0;
        for (int j = 1; j <= colCount; j++) {
            int i = cols[j];
            if (i == 0) continue;

            sum += maxWeight - costMap[i - 1][j - 1];
        }
        return sum;
    }
}
