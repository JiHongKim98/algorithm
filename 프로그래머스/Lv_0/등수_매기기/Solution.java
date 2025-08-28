/*
 * 프로그래머스 - 등수 매기기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120882
 */
package Lv_0.등수_매기기;

import java.util.Arrays;

class Solution {
    public int[] solution(int[][] score) {
        for (int i = 0; i < score.length; i++) {
            score[i][0] += score[i][1];
            score[i][1] = i;
        }

        Arrays.sort(score, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o2[0] - o1[0];
        });

        int rank = 1;
        int prevScore = score[0][0];

        int[] answer = new int[score.length];
        answer[score[0][1]] = rank;

        for (int i = 1; i < score.length; i++) {
            int currScore = score[i][0];
            int idx = score[i][1];

            if (currScore == prevScore) {
                answer[idx] = rank;
            } else {
                rank = i + 1;
                answer[idx] = rank;
                prevScore = currScore;
            }
        }

        return answer;
    }
}
