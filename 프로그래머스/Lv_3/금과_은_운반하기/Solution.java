/*
 * 프로그래머스 - 금과 은 운반하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/86053
 */
package Lv_3.금과_은_운반하기;

public class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long start = 0L;
        long end = 2L * 1_000_000_000 * 2 * 1_000_000;

        while (start < end) {
            long mid = (start + end) / 2;

            long totG = 0L;
            long totS = 0L;
            long totW = 0L;

            for (int i = 0; i < g.length; i++) {
                long moveTime = 2L * t[i];

                long maxMove = mid / moveTime;
                if (mid % moveTime >= t[i]) maxMove += 1;

                long maxW = maxMove * w[i];

                totG += Math.min(g[i], maxW);
                totS += Math.min(s[i], maxW);
                totW += Math.min(g[i] + s[i], maxW);
            }

            if (totG >= a && totS >= b && totW >= (a + b)) end = mid;
            else start = mid + 1;
        }

        return start;
    }
}
