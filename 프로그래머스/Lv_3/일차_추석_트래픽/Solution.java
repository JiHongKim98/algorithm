/*
 * 프로그래머스 - [1차] 추석 트래픽
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17676
 */
package Lv_3.일차_추석_트래픽;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;

        double[][] timeMap = new double[lines.length][2];

        for (int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(" ");
            timeMap[i] = processTime(split[1], split[2]);
        }

        for (int i = 0; i < lines.length; i++) {
            double windowStart = timeMap[i][1];
            double windowEnd = windowStart + 1;

            int curr = 0;

            for (int j = 0; j < lines.length; j++) {
                if (isContainTime(timeMap[j][0], timeMap[j][1], windowStart, windowEnd)) curr++;
            }

            answer = Math.max(curr, answer);
        }

        return answer;
    }

    private double[] processTime(String time, String seconds) {
        String[] splitTime = time.split(":");
        double end = (Double.parseDouble(splitTime[0]) * 3600) +
                (Double.parseDouble(splitTime[1]) * 60) +
                (Double.parseDouble(splitTime[2]));

        double doTime = Double.parseDouble(seconds.replace("s", ""));
        double start = end - doTime + 0.001;

        return new double[]{start, end};
    }

    private boolean isContainTime(double start, double end, double windowStart, double windowEnd) {
        return !(end < windowStart || start >= windowEnd);
    }
}
