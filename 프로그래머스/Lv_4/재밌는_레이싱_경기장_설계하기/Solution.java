/*
 * 프로그래머스 - 재밌는 레이싱 경기장 설계하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/214292
 */
package Lv_4.재밌는_레이싱_경기장_설계하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] heights) {
        Arrays.sort(heights);

        int len = heights.length;
        int mid = len / 2;

        List<Integer> diffMap = new ArrayList<>();

        for (int i = 0; i < mid + len % 2; i++) {
            if (i + mid < len) diffMap.add(heights[i + mid] - heights[i]);
        }

        Collections.sort(diffMap);

        return len % 2 == 0 ? diffMap.get(0) : diffMap.get(1);
    }
}
