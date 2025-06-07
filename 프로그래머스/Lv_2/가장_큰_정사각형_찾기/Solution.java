/*
 * 프로그래머스 - 가장 큰 정사각형 찾기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12905
 */
package Lv_2.가장_큰_정사각형_찾기;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        int[][] dp = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        dp[i][j] = Math.min(min, dp[i - 1][j - 1]) + 1;
                    }
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer * answer;
    }
}
