/*
 * 프로그래머스 - 격자 뒤집기 미로
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/389630
 */
package Lv_4.격자_뒤집기_미로;

class Solution {

    private int n, m, k;
    private int[][] hidden;
    private int[][] visible;

    public int solution(int[][] visible, int[][] hidden, int k) {
        this.k = k;
        this.n = hidden.length;
        this.m = hidden[0].length;
        this.hidden = hidden;
        this.visible = visible;

        int answer = Integer.MIN_VALUE;

        int totalCase = 1 << n;
        for (int mask = 0; mask < totalCase; mask++) {
            int cost = cal(mask);
            answer = Math.max(answer, cost);
        }

        return answer;
    }

    private int cal(int mask) {
        int total = 0;
        int minOdd = Integer.MAX_VALUE;

        int cost = -k * Integer.bitCount(mask);

        for (int x = 0; x < m; x++) {
            int sumNoFlip = 0, sumFlip = -k;
            int minNoFlip = Integer.MAX_VALUE, minFlip = Integer.MAX_VALUE;

            for (int y = 0; y < n; y++) {
                boolean isFlip = ((mask >> y) & 1) == 1;

                int flipNum = !isFlip ? hidden[y][x] : visible[y][x];
                int noFlipNum = isFlip ? hidden[y][x] : visible[y][x];

                sumFlip += flipNum;
                sumNoFlip += noFlipNum;

                if ((x + y) % 2 == 1) {
                    minFlip = Math.min(minFlip, flipNum);
                    minNoFlip = Math.min(minNoFlip, noFlipNum);
                }
            }

            total += Math.max(sumFlip, sumNoFlip);

            if (sumFlip < sumNoFlip) minOdd = Math.min(minOdd, minNoFlip);
            else minOdd = Math.min(minOdd, minFlip);
        }

        if (n % 2 == 0 && m % 2 == 0) return cost + total - minOdd;
        return cost + total;
    }
}
