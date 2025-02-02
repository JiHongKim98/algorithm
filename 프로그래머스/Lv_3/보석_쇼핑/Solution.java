/*
 * 프로그래머스 - 보석 쇼핑
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/67258
 */
package Lv_3.보석_쇼핑;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> gemMap = new HashSet<>();
        for (String gem : gems) {
            gemMap.add(gem);
        }

        Map<String, Integer> map = new HashMap<>();

        int start = 0;

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

            // 현재 시작점이 중복된 보석이 아니게 될때까지 시작점 한칸씩 증가
            while (map.get(gems[start]) != 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            if (map.size() == gemMap.size()) {
                int currentLen = i - start + 1;

                if (minLen > currentLen) {
                    minLen = currentLen;
                    answer[0] = start + 1;
                    answer[1] = i + 1;
                }
            }
        }

        return answer;
    }
}
