/*
 * 프로그래머스 - 할인 행사
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */
package Lv_2.할인_행사;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i <= discount.length - 10; i++) {
            boolean isFailed = false;

            Map<String, Integer> map = new HashMap<>();
            for (int w = 0; w < want.length; w++) {
                map.put(want[w], number[w]);
            }

            for (int j = i; j < i + 10; j++) {
                if (map.containsKey(discount[j]) && map.get(discount[j]) > 0) {
                    map.put(discount[j], map.get(discount[j]) - 1);
                } else {
                    isFailed = true;
                    break;
                }
            }

            if (!isFailed) answer++;
        }

        return answer;
    }
}
