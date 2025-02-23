/*
 * 프로그래머스 - 튜플
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065
 */
package Lv_2.튜플;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String s) {
        String[] split = s.split("}");

        Arrays.sort(split, (o1, o2) -> o1.length() - o2.length());

        int[] answer = new int[split.length];

        Set<Integer> map = new HashSet<>();

        int seq = 0;
        for (String sp : split) {
            String[] rows = sp.substring(2).split(",");

            for (String row : rows) {
                int num = Integer.parseInt(row);
                if (map.add(num)) {
                    answer[seq++] = num;
                    break;
                }
            }
        }
        return answer;
    }
}
