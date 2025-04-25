/*
 * 프로그래머스 - 쿠키 구입
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/49995
 */
package Lv_4.쿠키_구입;

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;

        for (int i = 0; i < cookie.length - 1; i++) {
            int left = i;
            int right = i + 1;

            int leftSum = cookie[left];
            int rightSum = cookie[right];

            while (true) {
                if (leftSum == rightSum) answer = Math.max(answer, leftSum);

                if (leftSum <= rightSum && left > 0) leftSum += cookie[--left];
                else if (leftSum > rightSum && right < cookie.length - 1) rightSum += cookie[++right];
                else break;
            }
        }

        return answer;
    }
}
