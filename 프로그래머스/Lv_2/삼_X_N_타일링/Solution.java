/*
 * 프로그래머스 - 3 x n 타일링
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12902
 */
package Lv_2.삼_X_N_타일링;

class Solution {
    public int solution(int n) {
        if (n % 2 != 0) return 0;

        int MOD = 1_000_000_007;

        long diff = 0;
        long answer = 1;
        for (int i = 1; i <= n / 2; i++) {
            long prev = answer;

            answer = prev * 3 + diff;
            diff = (answer - prev) % MOD;

            answer %= MOD;
        }

        return (int) answer;
    }
}
