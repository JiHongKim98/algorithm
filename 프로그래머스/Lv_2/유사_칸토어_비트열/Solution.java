/*
 * 프로그래머스 - 유사 칸토어 비트열
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/148652
 */
package Lv_2.유사_칸토어_비트열;

class Solution {

    private long l;
    private long r;

    public int solution(int n, long l, long r) {
        this.l = l - 1;
        this.r = r - 1;

        long end = 1;
        for (int i = 0; i < n; i++) end *= 5;

        return DFS(n, 0, end - 1);
    }

    private int DFS(int depth, long start, long end) {
        if (r < start || end < l) return 0;
        else if (depth == 0) return 1;

        int count = 0;
        long size = (end - start + 1) / 5;
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue;

            long splitStart = start + i * size;
            long splitEnd = splitStart + size - 1;

            count += DFS(depth - 1, splitStart, splitEnd);
        }
        return count;
    }
}
