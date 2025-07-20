/*
 * 프로그래머스 - 두 개 뽑아서 더하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/68644
 */
package Lv_1.두_개_뽑아서_더하기;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> map = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                map.add(numbers[i] + numbers[j]);
            }
        }

        return map.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
