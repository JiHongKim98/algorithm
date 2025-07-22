/*
 * 프로그래머스 - 숫자 문자열과 영단어
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/134240
 */
package Lv_1.숫자_문자열과_영단어;

class Solution {

    private String[] map = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public int solution(String s) {
        for (int i = 0; i < map.length; i++) {
            while (s.contains(map[i])) {
                s = s.replace(map[i], String.valueOf(i));
            }
        }
        return Integer.parseInt(s);
    }
}
