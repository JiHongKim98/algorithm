/*
 * 프로그래머스 - 소수_찾기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12921
 */
package Lv_1.소수_찾기;

class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) answer++;
        }

        return answer;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
