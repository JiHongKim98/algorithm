/*
 * 프로그래머스 - 메뉴 리뉴얼
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */
package Lv_2.메뉴_리뉴얼;

import java.util.*;

class Solution {

    private Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();

        for (String order : orders) {
            char[] orderMap = order.toCharArray();
            Arrays.sort(orderMap);

            for (int c : course) {
                combi("", 0, orderMap, c);
            }
        }

        List<String> results = new ArrayList<>();
        for (int c : course) {
            int maxOrder = 2;

            for (String key : map.keySet()) {
                if (key.length() == c && map.get(key) >= maxOrder) {
                    maxOrder = map.get(key);
                }
            }

            for (String key : map.keySet()) {
                if (key.length() == c && map.get(key) == maxOrder) {
                    results.add(key);
                }
            }
        }

        Collections.sort(results);

        String[] answer = new String[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }

    private void combi(String curr, int idx, char[] orderMap, int max) {
        if (curr.length() == max) {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            return;
        } else if (idx >= orderMap.length) {
            return;
        }

        combi(curr, idx + 1, orderMap, max);
        combi(curr + orderMap[idx], idx + 1, orderMap, max);
    }
}
