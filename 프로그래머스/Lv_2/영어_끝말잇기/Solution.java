/*
 * 프로그래머스 - 영어 끝말잇기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */
package Lv_2.영어_끝말잇기;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> map = new HashSet<>();

        map.add(words[0]);
        String before = words[0];

        for (int i = 1; i < words.length; i++) {
            if (
                    before.charAt(before.length() - 1) != words[i].charAt(0) ||
                            !map.add(words[i])
            ) {
                int num1 = (i + 1) % n;
                int num2 = (i + 1) / n;

                return new int[]{num1 == 0 ? n : num1, num1 == 0 ? num2 : num2 + 1};
            }

            before = words[i];
        }

        return new int[]{0, 0};
    }
}
