/*
 * 프로그래머스 - 퍼즐 게임 챌린지
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/340212
 */
package Lv_2.퍼즐_게임_챌린지;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int minLevel = 1;
        int maxLevel = 100_000;

        int answer = maxLevel;

        while (minLevel <= maxLevel) {
            int level = (minLevel + maxLevel) / 2;

            long currentTime = 0;
            long prevTime = 0;

            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] > level) {
                    currentTime += (diffs[i] - level) * (times[i] + prevTime) + times[i];
                } else {
                    currentTime += times[i];
                }

                if (currentTime > limit) {
                    break;
                }

                prevTime = times[i];
            }

            if (currentTime > limit) {
                minLevel = level + 1;
            } else {
                answer = level;

                maxLevel = level - 1;
            }
        }

        return answer;
    }
}
