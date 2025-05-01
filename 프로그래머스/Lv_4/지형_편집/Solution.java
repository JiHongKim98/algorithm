/*
 * 프로그래머스 - 지형 편집
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12984
 */
package Lv_4.지형_편집;

import java.util.Arrays;

public class Solution {
    public long solution(int[][] land, int P, int Q) {
        long answer = Long.MAX_VALUE;

        long TOTAL = 0;
        int[] map = new int[land.length * land.length];
        for (int i = 0; i < map.length; i++) {
            map[i] = land[i / land.length][i % land.length];
            TOTAL += map[i];
        }

        Arrays.sort(map);

        long currSum = 0;  // 누적
        long currHeight = -1;

        for (int i = 0; i < map.length; i++) {
            long currCount = map[i];

            if (currCount != currHeight) {
                long appendCount = (currCount * i) - currSum;
                long removeCount = TOTAL - currSum - (map.length - i) * currCount;

                answer = Math.min(answer, (appendCount * P) + (removeCount * Q));

                currHeight = currCount;
            }

            currSum += currCount;
        }

        return answer;
    }
}
