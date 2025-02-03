/*
 * 프로그래머스 - 징검다리 건너기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/64062
 */
package Lv_3.징검다리_건너기;

class Solution {
    public int solution(int[] stones, int k) {
        int min = 1;
        int max = 200_000_000;

        while (min <= max) {
            int mid = (max + min) / 2;

            int jump = 0;
            int maxJump = 0;

            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - mid <= 0) {
                    jump++;
                    maxJump = Math.max(jump, maxJump);
                } else {
                    jump = 0;
                }
            }

            if (maxJump <= k - 1) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return min;
    }
}
