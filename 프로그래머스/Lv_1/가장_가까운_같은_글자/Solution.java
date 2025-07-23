/*
 * 프로그래머스 - 가장 가까운 같은 글자
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/142086
 */
package Lv_1.가장_가까운_같은_글자;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int idx = map.getOrDefault(curr, -1);

            answer[i] = idx == -1 ? -1 : i - idx;

            map.put(curr, i);
        }

        return answer;
    }
}
