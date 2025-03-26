/*
 * 프로그래머스 - 연속된 부분 수열의 합
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */
package Lv_2.연속된_부분_수열의_합;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int point1 = 0;
        int point2 = 0;
        int sum = sequence[0];

        List<int[]> map = new ArrayList<>();

        while (point2 < sequence.length) {
            if (sum == k) map.add(new int[]{point1, point2, point2 - point1});

            if (sum <= k) {
                point2++;
                if (point2 < sequence.length) sum += sequence[point2];
            } else {
                sum -= sequence[point1++];
            }
        }

        int maxDiff = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for (int[] m : map) {
            if (m[2] < maxDiff) {
                answer[0] = m[0];
                answer[1] = m[1];
                maxDiff = m[2];
            }
        }

        return answer;
    }
}
