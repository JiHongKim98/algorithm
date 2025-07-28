/*
 * 프로그래머스 - 같은 숫자는 싫어
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */
package Lv_1.같은_숫자는_싫어;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> map = new ArrayList<>();

        int mem = -1;

        for (int a : arr) {
            if (mem != a) map.add(a);
            mem = a;
        }

        return map.stream().mapToInt(Integer::intValue).toArray();
    }
}
