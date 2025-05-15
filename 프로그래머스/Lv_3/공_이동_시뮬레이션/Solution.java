/*
 * 프로그래머스 - 공 이동 시뮬레이션
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/87391
 */
package Lv_3.공_이동_시뮬레이션;

class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long startX = x;
        long endX = x;

        long startY = y;
        long endY = y;

        for (int i = queries.length - 1; i >= 0; i--) {
            int oper = queries[i][0];
            int move = queries[i][1];

            if (oper == 0) {
                if (startY != 0) startY += move;
                endY = Math.min(endY + move, m - 1);
            } else if (oper == 1) {
                startY = Math.max(0, startY - move);
                if (endY != m - 1) endY -= move;
            } else if (oper == 2) {
                if (startX != 0) startX += move;
                endX = Math.min(endX + move, n - 1);
            } else {
                startX = Math.max(0, startX - move);
                if (endX != n - 1) endX -= move;
            }

            if (startX > n - 1 || endX < 0 || startY > m - 1 || endY < 0) return 0;
        }

        return (endX - startX + 1) * (endY - startY + 1);
    }
}
