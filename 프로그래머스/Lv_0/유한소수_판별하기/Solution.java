/*
 * 프로그래머스 - 유한소수 판별하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120878
 */
package Lv_0.유한소수_판별하기;

class Solution {
    public int solution(int a, int b) {
        b /= gcd(a, b);

        while (b != 1) {
            if (b % 2 == 0) b /= 2;
            else if (b % 5 == 0) b /= 5;
            else return 2;
        }

        return 1;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
