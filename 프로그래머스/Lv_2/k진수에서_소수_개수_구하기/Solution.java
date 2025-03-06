/*
 * 프로그래머스 - k진수에서 소수 개수 구하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */
package Lv_2.k진수에서_소수_개수_구하기;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String convert = Integer.toString(n, k);
        String[] splits = convert.split("0");

        for (String sp : splits) {
            if (!sp.isEmpty() && isPossible(Long.parseLong(sp))) answer++;
        }

        return answer;
    }

    private boolean isPossible(long num) {
        if (num == 1) return false;
        else if (num == 2) return true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
