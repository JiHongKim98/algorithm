/*
 * 프로그래머스 - 접미사 배열
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181909
 */
package Lv_0.접미사_배열;

import java.util.Arrays;

class Solution {
    public String[] solution(String my_string) {
        int len = my_string.length();

        String[] answer = new String[len];
        for (int i = 0; i < len; i++) answer[i] = my_string.substring(i, len);

        Arrays.sort(answer);
        return answer;
    }
}
