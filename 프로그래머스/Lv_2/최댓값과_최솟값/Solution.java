/*
 * 프로그래머스 - 최댓값과 최솟값
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12939
 */
package Lv_2.최댓값과_최솟값;

class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String sp : split) {
            int parse = Integer.parseInt(sp);
            max = Math.max(max, parse);
            min = Math.min(min, parse);
        }

        return min + " " + max;
    }
}
