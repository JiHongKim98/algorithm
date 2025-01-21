/*
 * 프로그래머스 - 두 원 사이의 정수 쌍
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181187
 */
package Lv_2.두_원_사이의_정수_쌍;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int i = 1; i <= r2; i++) {
            // y^2 = x^2 - c^2
            long r1p = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));
            long r2p = (long) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));

            answer += (r2p - r1p + 1);
        }

        return answer * 4;
    }
}
