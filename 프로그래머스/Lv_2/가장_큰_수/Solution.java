/*
 * 프로그래머스 - 가장 큰 수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
package Lv_2.가장_큰_수;

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] map = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) map[i] = numbers[i] + "";

        Arrays.sort(map, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        if (Integer.parseInt(map[numbers.length - 1]) == 0) {
            return "0";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = map.length - 1; i >= 0; i--) sb.append(map[i]);
            return sb.toString();
        }
    }
}
