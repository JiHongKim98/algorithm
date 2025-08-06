/*
 * 프로그래머스 - 겹치는 선분의 길이
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120876
 */
package Lv_0.겹치는_선분의_길이;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] lines) {
        List<int[]> map = new ArrayList<>();
        for (int[] line : lines) {
            map.add(new int[]{line[0], 1});
            map.add(new int[]{line[1], -1});
        }

        map.sort((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int start = 0;
        int active = 0;
        int answer = 0;
        for (int[] m : map) {
            int currStart = m[0];

            if (active >= 2) answer += currStart - start;

            active += m[1];
            start = currStart;
        }

        return answer;
    }
}
