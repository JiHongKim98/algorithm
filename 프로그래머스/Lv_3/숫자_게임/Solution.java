/*
 * 프로그래머스 - 숫자 게임
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12987
 */
package Lv_3.숫자_게임;

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int bMaxPoint = B.length - 1;

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < B[bMaxPoint]) {
                answer++;
                bMaxPoint--;
            }
        }
        return answer;
    }
}
