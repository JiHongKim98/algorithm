/*
 * 프로그래머스 - 사라지는 발판
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/92345
 */
package Lv_3.사라지는_발판;

class Solution {

    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    private int[][] board;

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        return DFS(aloc[0], aloc[1], bloc[0], bloc[1]);
    }

    private int DFS(int currX, int currY, int otherX, int otherY) {
        if (board[currX][currY] == 0) return 0;

        int max = 0;
        int min = Integer.MAX_VALUE;

        board[currX][currY] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = currX + dx[i];
            int nextY = currY + dy[i];

            if (
                    nextX < 0 || nextX >= board.length ||
                            nextY < 0 || nextY >= board[0].length ||
                            board[nextX][nextY] == 0
            ) continue;

            int move = DFS(otherX, otherY, nextX, nextY);  // 턴 변경

            if (move % 2 == 0) min = Math.min(min, move + 1);
            else max = Math.max(max, move + 1);
        }

        board[currX][currY] = 1;

        return min != Integer.MAX_VALUE ? min : max;
    }
}
