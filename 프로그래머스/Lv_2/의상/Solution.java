/*
 * 프로그래머스 - 의상
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
package Lv_2.의상;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Set<String>> map = new HashMap<>();

        for (String[] cloth : clothes) map.computeIfAbsent(cloth[1], k -> new HashSet<>()).add(cloth[0]);

        int answer = 1;

        for (String key : map.keySet()) answer *= map.get(key).size() + 1;

        return answer - 1;
    }
}
