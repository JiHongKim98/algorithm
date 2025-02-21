/*
 * 프로그래머스 - [1차] 캐시
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */
package Lv_2.캐시;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> map = new ArrayList<>();

        int answer = 0;
        for (String city : cities) {
            String key = city.toUpperCase();

            if (map.contains(key)) {
                answer += 1;
                map.remove(key);
            } else {
                answer += 5;
            }

            map.add(key);

            if (map.size() > cacheSize) map.removeFirst();
        }

        return answer;
    }
}
