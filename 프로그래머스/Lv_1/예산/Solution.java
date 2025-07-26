/*
 * 프로그래머스 - 예산
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12982
 */
package Lv_1.예산;

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int answer = 0;
        for (int i : d) {
            budget -= i;

            if (budget >= 0) answer++;
            else break;
        }

        return answer;
    }
}
