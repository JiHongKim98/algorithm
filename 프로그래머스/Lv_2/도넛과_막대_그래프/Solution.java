/*
 * 프로그래머스 - 도넛과 막대 그래프
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/258711
 */
package Lv_2.도넛과_막대_그래프;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        Map<Integer, int[]> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new int[2]);
            map.putIfAbsent(edge[1], new int[2]);
            map.get(edge[0])[1]++;
            map.get(edge[1])[0]++;
        }

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int node = entry.getKey();
            int input = entry.getValue()[0];
            int output = entry.getValue()[1];

            if (input == 0 && output >= 2) answer[0] = node;
            else if (input >= 1 && output == 0) answer[2]++;
            else if (input >= 2 && output >= 2) answer[3]++;
        }

        int start = answer[0];
        answer[1] = map.get(start)[1] - answer[2] - answer[3];

        return answer;
    }
}
