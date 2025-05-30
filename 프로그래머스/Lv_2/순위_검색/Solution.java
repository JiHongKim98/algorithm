/*
 * 프로그래머스 - 순위 검색
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/72412
 */
package Lv_2.순위_검색;

import java.util.*;

class Solution {

    private String[][] infos;
    private Map<String, List<Integer>> map = new HashMap();

    public int[] solution(String[] info, String[] queries) {
        infos = new String[info.length][5];
        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");
            for (int j = 0; j < 5; j++) infos[i][j] = split[j];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i].replaceAll(" and ", " ").split(" ");
            answer[i] = search(query);
        }

        return answer;
    }

    private int search(String[] query) {
        int score = Integer.parseInt(query[4]);
        String key = query[0] + query[1] + query[2] + query[3];

        if (!map.containsKey(key)) createKey(query);

        List<Integer> currMap = map.get(key);

        int start = 0;
        int end = currMap.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (currMap.get(mid) < score) start = mid + 1;
            else end = mid - 1;
        }

        return currMap.size() - start;
    }

    private void createKey(String[] query) {
        List<Integer> currList = new ArrayList<>();

        loop:
        for (String[] info : infos) {
            for (int i = 0; i < 4; i++) {
                if (!info[i].equals(query[i]) && !query[i].equals("-")) continue loop;
            }
            currList.add(Integer.parseInt(info[4]));
        }

        Collections.sort(currList);
        map.put(query[0] + query[1] + query[2] + query[3], currList);
    }
}
