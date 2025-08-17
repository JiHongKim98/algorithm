/*
 * 프로그래머스 - 안전지대
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120866
 */
package Lv_0.안전지대;

class Solution {

    private int[] dx = {0, 0, -1, 1, 1, -1, 1, -1};
    private int[] dy = {-1, 1, 0, 0, 1, 1, -1, -1};

    private int answer;
    private int len;
    private int[][] board;
    private boolean[][] visit;

    public int solution(int[][] board) {
        this.board = board;
        this.len = board.length;

        answer = len * len;
        visit = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 1) check(i, j);
            }
        }

        return answer;
    }

    private void check(int x, int y) {
        answer--;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= len || ny < 0 || ny >= len) continue;
            if (visit[nx][ny] || board[nx][ny] == 1) continue;

            visit[nx][ny] = true;
            answer--;
        }
    }
}
