/*
 * 프로그래머스 - 미로 탈출 명령어
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/150365
 */
package Lv_3.미로_탈출_명령어;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int total = Math.abs(x - r) + Math.abs(y - c);
        if (k < total || (k - total) % 2 != 0) return "impossible";

        StringBuilder sb = new StringBuilder();

        int remain = (k - total) / 2;

        while (remain > 0) {
            if (x < n) {
                sb.append('d');
                x++;
                k--;
            } else if (y > 1) {
                sb.append('l');
                y--;
                k--;
            } else {
                break;
            }

            total = Math.abs(x - r) + Math.abs(y - c);
            remain = (k - total) / 2;
        }

        sb.append("rl".repeat(remain));

        sb.append("d".repeat(Math.max(0, r - x)));
        sb.append("l".repeat(Math.max(0, y - c)));
        sb.append("r".repeat(Math.max(0, c - y)));
        sb.append("u".repeat(Math.max(0, x - r)));

        return sb.toString();
    }
}
