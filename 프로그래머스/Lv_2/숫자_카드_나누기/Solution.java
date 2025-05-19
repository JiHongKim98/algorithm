/*
 * 프로그래머스 - 숫자 카드 나누기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/135807
 */
package Lv_2.숫자_카드_나누기;

import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        for (int i = Math.max(arrayA[0], arrayB[0]); i >= 2; i--) {
            if (isDiv(arrayA, i) && isNotDiv(arrayB, i)) return i;
            if (isDiv(arrayB, i) && isNotDiv(arrayA, i)) return i;
        }

        return 0;
    }

    private boolean isDiv(int[] arr, int num) {
        for (int i : arr) {
            if (i % num != 0) return false;
        }
        return true;
    }

    private boolean isNotDiv(int[] arr, int num) {
        for (int i : arr) {
            if (i % num == 0) return false;
        }
        return true;
    }
}
