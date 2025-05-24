/*
 * 프로그래머스 - 광물 캐기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 */
package Lv_2.광물_캐기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        List<String[]> groupMap = new ArrayList<>();

        int max = Math.min(minerals.length, (picks[0] + picks[1] + picks[2]) * 5);
        for (int i = 0; i < max; i += 5) {
            groupMap.add(Arrays.copyOfRange(minerals, i, Math.min(i + 5, max)));
        }

        groupMap.sort((o1, o2) -> fatigue(o2, "stone") - fatigue(o1, "stone"));

        int answer = 0;
        for (String[] group : groupMap) {
            if (picks[0] != 0) {
                picks[0]--;
                answer += fatigue(group, "diamond");
            } else if (picks[1] != 0) {
                picks[1]--;
                answer += fatigue(group, "iron");
            } else if (picks[2] != 0) {
                picks[2]--;
                answer += fatigue(group, "stone");
            }
        }

        return answer;
    }

    private int fatigue(String[] group, String currAxe) {
        int sum = 0;
        for (String g : group) {
            switch (currAxe) {
                case "diamond":
                    sum += 1;
                    break;
                case "iron":
                    if (g.equals("diamond")) sum += 5;
                    else sum += 1;
                    break;
                case "stone":
                    if (g.equals("diamond")) sum += 25;
                    else if (g.equals("iron")) sum += 5;
                    else sum += 1;
                    break;
            }
        }

        return sum;
    }
}
