/*
 * 프로그래머스 - 카드 짝 맞추기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/72415
 */
package Lv_3.카드_짝_맞추기;

import java.util.*;

class Solution {

    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};

    private int answer;
    private Map<Integer, List<int[]>> map;

    public int solution(int[][] board, int r, int c) {
        answer = Integer.MAX_VALUE;
        map = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    map.computeIfAbsent(board[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }
        int enterCost = map.size() * 2;

        List<Integer> cards = new ArrayList<>(map.keySet());
        permute(r, c, cards, new ArrayList<>(), board, 0);

        return answer + enterCost;
    }

    private void permute(int r, int c, List<Integer> cards, List<Integer> order, int[][] board, int depth) {
        if (depth == cards.size()) {
            dfs(r, c, copyArray(board), order, 0, 0);
            return;
        }

        for (int i = depth; i < cards.size(); i++) {
            Collections.swap(cards, i, depth);
            order.add(cards.get(depth));

            permute(r, c, cards, order, board, depth + 1);

            order.remove(order.size() - 1);
            Collections.swap(cards, i, depth);
        }
    }

    private void dfs(int r, int c, int[][] board, List<Integer> order, int depth, int cost) {
        if (depth == order.size()) {
            answer = Math.min(answer, cost);
            return;
        }

        int target = order.get(depth);
        List<int[]> pos = map.get(target);

        for (int i = 0; i < 2; i++) {
            int[] first = pos.get(i);
            int[] second = pos.get(1 - i);

            int addCost = move(r, c, first[0], first[1], board) +
                    move(first[0], first[1], second[0], second[1], board);

            board[first[0]][first[1]] = 0;
            board[second[0]][second[1]] = 0;

            dfs(second[0], second[1], copyArray(board), order, depth + 1, cost + addCost);

            board[first[0]][first[1]] = target;
            board[second[0]][second[1]] = target;
        }
    }

    private int move(int currX, int currY, int targetX, int targetY, int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{currX, currY, 0});

        boolean[][] visit = new boolean[4][4];
        visit[currX][currY] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], cost = poll[2];

            if (x == targetX && y == targetY) return cost;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i], nextY = y + dy[i];
                if (check(nextX, nextY) && !visit[nextX][nextY]) {
                    visit[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, cost + 1});
                }

                int ctrlX = x, ctrlY = y;
                while (check(ctrlX + dx[i], ctrlY + dy[i])) {
                    ctrlX += dx[i];
                    ctrlY += dy[i];

                    if (board[ctrlX][ctrlY] != 0) break;
                }
                if (!visit[ctrlX][ctrlY]) {
                    visit[ctrlX][ctrlY] = true;
                    queue.add(new int[]{ctrlX, ctrlY, cost + 1});
                }
            }
        }
        return -1;
    }

    private int[][] copyArray(int[][] board) {
        int[][] copy = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }

    private boolean check(int x, int y) {
        return 0 <= x && x < 4 && 0 <= y && y < 4;
    }
}
