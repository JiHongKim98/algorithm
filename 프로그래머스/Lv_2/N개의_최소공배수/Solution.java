/*
 * 프로그래머스 - N개의 최소공배수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12953
 */
package Lv_2.N개의_최소공배수;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        for (int curr : arr) {
            int A = Math.max(answer, curr);
            int B = Math.min(answer, curr);

            answer = (A * B) / gcd(A, B);
        }
        return answer;
    }

    private int gcd(int x, int y) {
        if (x % y == 0) return y;
        return gcd(y, x % y);
    }
}
