/*
 * 프로그래머스 - 평행
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120875
 */
package Lv_0.평행;

class Solution {
    public int solution(int[][] dots) {
        if (check(dots[0], dots[1], dots[2], dots[3])) return 1;
        else if (check(dots[0], dots[2], dots[1], dots[3])) return 1;
        else if (check(dots[0], dots[3], dots[1], dots[2])) return 1;
        return 0;
    }

    private boolean check(int[] a, int[] b, int[] c, int[] d) {
        int dx1 = a[0] - b[0];
        int dy1 = a[1] - b[1];
        int dx2 = c[0] - d[0];
        int dy2 = c[1] - d[1];

        return dx1 * dy2 == dx2 * dy1;
    }
}
