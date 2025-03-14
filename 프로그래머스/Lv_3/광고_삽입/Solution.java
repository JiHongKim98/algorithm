/*
 * 프로그래머스 - 광고 삽입
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/72414
 */
package Lv_3.광고_삽입;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSeconds = convertSeconds(play_time);
        int advSeconds = convertSeconds(adv_time);

        long[] time = new long[playSeconds + 1];

        int lastTime = 0;

        for (String log : logs) {
            String[] split = log.split("-");

            int start = convertSeconds(split[0]);
            int end = convertSeconds(split[1]);
            time[start] += 1;
            time[end] -= 1;

            lastTime = Math.max(end, lastTime);
        }

        for (int i = 1; i < lastTime + 1; i++) {
            time[i] += time[i - 1];  // 현재 시청자 수
        }

        for (int i = 1; i < lastTime + 1; i++) {
            time[i] += time[i - 1];  // 현재 시청자 누적합
        }

        int max = 0;
        long maxView = time[advSeconds - 1];

        for (int i = 1; i < playSeconds - advSeconds + 1; i++) {
            long curr = time[i + advSeconds - 1] - time[i - 1];

            if (curr > maxView) {
                maxView = curr;
                max = i;
            }
        }

        return convertTimeString(max);
    }

    private int convertSeconds(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 3600
                + Integer.parseInt(split[1]) * 60
                + Integer.parseInt(split[2]);
    }

    private String convertTimeString(int seconds) {
        return String.format(
                "%02d:%02d:%02d",
                seconds / 3600,
                (seconds % 3600) / 60,
                seconds % 60
        );
    }
}
