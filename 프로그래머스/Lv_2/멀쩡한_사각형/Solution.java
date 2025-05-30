/*
 * 프로그래머스 - 멀쩡한 사각형
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/62048
 */
package Lv_2.멀쩡한_사각형;

class Solution {
    public long solution(int w, int h) {
        int gcd = getGcd(w, h);
        long unused = (w / gcd) * (h / gcd) - (w / gcd - 1) * (h / gcd - 1);
        long answer = ((long) w * h) - (unused * gcd);
        return answer;
    }

    private int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
}
