/*
 * 프로그래머스 - 특이한 정렬
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120880
 */
package Lv_0.특이한_정렬;

import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        Map<Integer, List<Integer>> distMap = new HashMap<>();

        int maxDist = 0;
        for (int num : numlist) {
            int dist = Math.abs(n - num);
            maxDist = Math.max(maxDist, dist);

            distMap.computeIfAbsent(dist, d -> new ArrayList<>()).add(num);
        }

        int idx = 0;
        int[] answer = new int[numlist.length];
        for (int d = 0; d <= maxDist; d++) {
            if (!distMap.containsKey(d)) continue;

            List<Integer> map = distMap.get(d);
            Collections.sort(map, Collections.reverseOrder());

            for (int num : map) answer[idx++] = num;
        }

        return answer;
    }
}
