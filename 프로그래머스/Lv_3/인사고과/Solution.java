/*
 * 프로그래머스 - 인사고과
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/152995
 */
package Lv_3.인사고과;

import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        int a = scores[0][0];
        int b = scores[0][1];
        int WONHO = a + b;

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];  // 동료 평가 오름차순
            }
            return o2[0] - o1[0];  // 근무 태도 내림차순
        });

        int maxB = Integer.MIN_VALUE;
        int answer = 1;  // 등수
        for (int[] score : scores) {
            if (maxB <= score[1]) {
                if (score[0] + score[1] > WONHO) {
                    answer++;
                }
                maxB = score[1];
            } else {
                // 동료 평가가 오름차순 이므로, 원호의 근무 태도 점수가 지금까지 나온 최대 점수보다 낮은 경우
                if (score[0] == a && score[1] == b) return -1;
            }
        }

        return answer;
    }
}
