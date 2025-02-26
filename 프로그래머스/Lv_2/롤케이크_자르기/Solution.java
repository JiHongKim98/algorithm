/*
 * 프로그래머스 - 롤케이크 자르기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */
package Lv_2.롤케이크_자르기;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int top : topping) {
            map.put(top, map.getOrDefault(top, 0) + 1);
        }

        Map<Integer, Integer> divMap = new HashMap<>();
        for (int top : topping) {
            divMap.put(top, divMap.getOrDefault(top, 0) + 1);

            if (map.containsKey(top)) {
                int curr = map.getOrDefault(top, 0);
                if (curr == 1) map.remove(top);
                else map.put(top, curr - 1);
            }

            if (map.size() == divMap.size()) answer++;
        }

        return answer;
    }
}
