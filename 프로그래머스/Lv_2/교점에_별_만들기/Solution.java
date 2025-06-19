/*
 * 프로그래머스 - 교점에 별 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/87377
 */
package Lv_2.교점에_별_만들기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(int[][] line) {
        int startX = Integer.MAX_VALUE;
        int endX = Integer.MIN_VALUE;

        int startY = Integer.MAX_VALUE;
        int endY = Integer.MIN_VALUE;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long div = ((long) line[i][0] * line[j][1]) - ((long) line[i][1] * line[j][0]);

                long numX = ((long) line[i][1] * line[j][2]) - ((long) line[i][2] * line[j][1]);
                long numY = ((long) line[i][2] * line[j][0]) - ((long) line[i][0] * line[j][2]);
                if (div == 0 || numX % div != 0 || numY % div != 0) continue;

                int x = (int) (numX / div);
                int y = (int) (numY / div);

                map.computeIfAbsent(x, k -> new ArrayList<>()).add(y);

                startX = Math.min(startX, x);
                endX = Math.max(endX, x);

                startY = Math.min(startY, y);
                endY = Math.max(endY, y);
            }
        }

        String[] answer = new String[endY - startY + 1];

        int idx = 0;
        for (int i = endY; i >= startY; i--) {
            StringBuilder sb = new StringBuilder();

            for (int j = startX; j <= endX; j++) {
                if (map.containsKey(j) && map.get(j).contains(i)) sb.append('*');
                else sb.append('.');
            }

            answer[idx++] = sb.toString();
        }
        return answer;
    }
}
