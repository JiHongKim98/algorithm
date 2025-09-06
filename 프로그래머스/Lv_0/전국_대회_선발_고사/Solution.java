/*
 * 프로그래머스 - 전국 대회 선발 고사
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181851
 */
package Lv_0.전국_대회_선발_고사;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] idx = new int[rank.length + 1];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rank.length; i++) {
            idx[rank[i]] = i;

            if (attendance[i]) list.add(rank[i]);
        }

        Collections.sort(list);

        return idx[list.get(0)] * 10000 + idx[list.get(1)] * 100 + idx[list.get(2)];
    }
}
