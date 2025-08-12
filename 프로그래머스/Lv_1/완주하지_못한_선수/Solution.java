/*
 * 프로그래머스 - 완주하지 못한 선수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
package Lv_1.완주하지_못한_선수;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String comp : completion) map.put(comp, map.getOrDefault(comp, 0) + 1);

        for (String part : participant) {
            if (map.containsKey(part)) {
                int count = map.get(part);
                if (count != 0) {
                    map.put(part, count - 1);
                    continue;
                }
            }
            return part;
        }
        return "";
    }
}
