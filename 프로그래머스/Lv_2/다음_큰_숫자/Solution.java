/*
 * 프로그래머스 - 다음 큰 숫자
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 */
package Lv_2.다음_큰_숫자;

class Solution {
    public int solution(int n) {
        int bits = Integer.bitCount(n);

        for (int i = 1; i < 1_000_001; i++) {
            if (bits == Integer.bitCount(n + i)) return n + i;
        }
        return -1;
    }
}
