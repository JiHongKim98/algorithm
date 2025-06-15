/*
 * 프로그래머스 - 우박수열 정적분
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/134239
 */
package Lv_2.우박수열_정적분;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> map = new ArrayList<>();

        int num = k;
        while (true) {
            map.add(num);

            if (num == 1) break;
            else if (num % 2 == 0) num /= 2;
            else num = (num * 3) + 1;
        }

        double[] areaMap = new double[map.size() - 1];
        double[] sumMap = new double[map.size()];

        for (int i = 0; i < map.size() - 1; i++) areaMap[i] = (map.get(i) + map.get(i + 1)) / 2.0;

        sumMap[0] = 0;
        for (int i = 0; i < areaMap.length; i++) sumMap[i + 1] = sumMap[i] + areaMap[i];

        double[] answer = new double[ranges.length];
        int areaLen = areaMap.length;

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = areaLen + ranges[i][1];

            answer[i] = start > end ? -1 : sumMap[end] - sumMap[start];
        }

        return answer;
    }
}
