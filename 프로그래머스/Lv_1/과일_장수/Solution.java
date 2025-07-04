/*
 * 프로그래머스 - 과일 장수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/135808
 */
package Lv_1.과일_장수;

import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);

        int answer = 0;
        int count = 0;
        int currMin = k;
        for (int i = score.length - 1; i >= 0; i--) {
            count++;

            currMin = Math.min(currMin, score[i]);

            if (count == m) {
                answer += m * currMin;
                currMin = k;
                count = 0;
            }
        }

        return answer;
    }
}
