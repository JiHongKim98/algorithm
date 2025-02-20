/*
 * 프로그래머스 - 주차 요금 계산
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */
package Lv_2.주차_요금_계산;

import java.util.Map;
import java.util.TreeMap;

class Solution {

    private int[] fees;
    private static final int MAX = 60 * 23 + 59;

    public int[] solution(int[] fees, String[] records) {
        this.fees = fees;

        Map<String, int[]> map = new TreeMap<>();

        for (String record : records) {
            String[] split = record.split(" ");

            int time = convertToTime(split[0]);
            String car = split[1];

            // IN시간, IN-OUT, 누적시간
            int[] current = map.getOrDefault(car, new int[]{0, 0, 0});

            if (split[2].equals("IN")) {
                map.put(car, new int[]{time, 1, current[2]});
            } else {
                int total = time - current[0] + current[2];
                map.put(car, new int[]{0, 0, total});
            }
        }

        int[] answer = new int[map.size()];

        int seq = 0;
        for (String key : map.keySet()) {
            int[] current = map.get(key);
            if (current[1] != 0) {
                current[2] += MAX - current[0];
            }
            answer[seq++] = process(current[2]);
        }
        return answer;
    }

    private int convertToTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private int process(int total) {
        if (total <= fees[0]) return fees[1];
        return fees[1] + (int) Math.ceil((total - fees[0]) / (double) fees[2]) * fees[3];
    }
}
