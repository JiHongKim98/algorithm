/*
 * 프로그래머스 - 배열 조각하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181893
 */
package Lv_0.배열_조각하기;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int left = 0;
        int right = arr.length - 1;

        int time = 0;
        for (int q : query) {
            if (time % 2 != 0) left += q;
            else right = left + q;

            time++;
        }

        return Arrays.copyOfRange(arr, left, right + 1);
    }
}
