/*
 * 프로그래머스 - [1차] 셔틀버스
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17678
 */
package Lv_3.일차_셔틀버스;

import java.util.Arrays;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] timeMap = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            timeMap[i] = convertToSeconds(timetable[i]);
        }

        Arrays.sort(timeMap);

        int start = 60 * 9;
        int lastTime = start;
        int sequence = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;

            while (count < m && sequence != timetable.length && timeMap[sequence] <= start) {
                lastTime = timeMap[sequence] - 1;

                sequence++;
                count++;
            }

            if (i == n - 1 && count < m) {
                lastTime = start;
            }

            start += t;
        }

        return convertToTimeFormat(lastTime);
    }

    private int convertToSeconds(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private String convertToTimeFormat(int time) {
        int hour = time / 60;
        int min = time % 60;
        return String.format("%02d:%02d", hour, min);
    }
}
