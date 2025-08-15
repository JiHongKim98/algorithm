/*
 * 프로그래머스 - 분수의 덧셈
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120808
 */
package Lv_0.분수의_덧셈;

class Solution {

    private int currLcm;

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        currLcm = lcm(denom1, denom2);
        int numer = getNumer(numer1, denom1) + getNumer(numer2, denom2);
        int denom = currLcm;

        int currGcd = gcd(numer, denom);
        if (currGcd != 1) {
            numer /= currGcd;
            denom /= currGcd;
        }

        return new int[]{numer, denom};
    }

    public int getNumer(int num, int den) {
        int w = currLcm / den;
        return num * w;
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
