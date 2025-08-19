/*
 * 프로그래머스 - 최빈값 구하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120812
 */
package Lv_0.최빈값_구하기;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = -1;
        int answer = 0;
        for (int a : array) {
            int curr = map.getOrDefault(a, 0) + 1;

            if (curr > max) {
                answer = a;
                max = curr;
            } else if (curr == max) {
                answer = -1;
            }

            map.put(a, curr);
        }

        return answer;
    }
}
