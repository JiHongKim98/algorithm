/*
 * 프로그래머스 - 포켓몬
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
package Lv_1.포켓몬;

import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> map = new HashSet<>();

        for (int num : nums) map.add(num);

        return Math.min(map.size(), nums.length / 2);
    }
}
