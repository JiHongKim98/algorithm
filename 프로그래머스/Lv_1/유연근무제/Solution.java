/*
 * 프로그래머스 - 유연근무제
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/388351
 */
package Lv_1.유연근무제;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        startday--;

        int answer = 0;

        loop:
        for (int i = 0; i < timelogs.length; i++) {
            int currDay = startday;
            int maxTime = after10(schedules[i]);

            for (int j = 0; j < 7; j++) {
                if (currDay < 5 && timelogs[i][j] > maxTime) continue loop;
                currDay = (currDay + 1) % 7;
            }

            answer++;
        }

        return answer;
    }

    private int after10(int time) {
        int minute = time % 100;
        if (minute >= 50) return (time / 100) * 100 + 100 + minute - 50;
        return time + 10;
    }
}
