/*
 * 프로그래머스 - 가장 많이 받은 선물
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/258712
 */
package Lv_1.가장_많이_받은_선물;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int len = friends.length;

        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < len; i++) idxMap.put(friends[i], i);

        int[] score = new int[len];
        int[][] given = new int[len][len];
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            int giverIdx = idxMap.get(split[0]);
            int takerIdx = idxMap.get(split[1]);

            score[giverIdx]++;
            score[takerIdx]--;
            given[giverIdx][takerIdx]++;
        }

        int answer = -1;
        for (int i = 0; i < len; i++) {
            int currCount = 0;

            for (int j = 0; j < len; j++) {
                if (i == j) continue;

                if (given[i][j] > given[j][i]) currCount++;
                else if (given[i][j] == given[j][i] && score[i] > score[j]) currCount++;
            }

            answer = Math.max(answer, currCount);
        }

        return answer;
    }
}
