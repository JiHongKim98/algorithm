/*
 * 프로그래머스 - H-Index
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
package Lv_2.H_Index;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int len = citations.length;

        Arrays.sort(citations);

        for (int i = 0; i < len; i++) {
            if (citations[i] >= len - i) return len - i;
        }
        return 0;
    }
}
