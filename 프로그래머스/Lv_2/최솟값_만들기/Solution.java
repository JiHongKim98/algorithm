/*
 * 프로그래머스 - 최솟값 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */
package Lv_2.최솟값_만들기;

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int len = A.length;
        int answer = 0;
        for (int i = 0; i < len; i++) {
            answer += A[i] * B[len - i - 1];
        }

        return answer;
    }
}
