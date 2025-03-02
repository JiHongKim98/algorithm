/*
 * 프로그래머스 - 거리두기 확인하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302
 */
package Lv_2.거리두기_확인하기;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            char[][] map = new char[5][5];
            List<int[]> pMap = new ArrayList<>();

            String[] place = places[i];
            for (int j = 0; j < 5; j++) {
                String p = place[j];
                for (int k = 0; k < 5; k++) {
                    char curr = p.charAt(k);
                    map[j][k] = curr;

                    if (curr == 'P') pMap.add(new int[]{j, k});
                }
            }

            if (pMap.size() <= 1) answer[i] = 0;

            boolean isFailed = false;
            for (int j = 0; j < pMap.size() - 1; j++) {
                for (int k = j + 1; k < pMap.size(); k++) {
                    if (isFailed) continue;

                    int[] idx1 = pMap.get(j);
                    int[] idx2 = pMap.get(k);

                    int dis = Math.abs(idx1[0] - idx2[0]) + Math.abs(idx1[1] - idx2[1]);
                    if (dis == 1) isFailed = true;
                    else if (dis == 2 && !isPartitioned(idx1, idx2, map)) isFailed = true;
                }
            }

            answer[i] = isFailed ? 0 : 1;
        }

        return answer;
    }

    private boolean isPartitioned(int[] idx1, int[] idx2, char[][] map) {
        if (idx1[0] == idx2[0] && map[idx1[0]][(idx1[1] + idx2[1]) / 2] == 'X') return true;
        else if (idx1[1] == idx2[1] && map[(idx1[0] + idx2[0]) / 2][idx1[1]] == 'X') return true;
        else return map[idx1[0]][idx2[1]] == 'X' && map[idx2[0]][idx1[1]] == 'X';
    }
}
