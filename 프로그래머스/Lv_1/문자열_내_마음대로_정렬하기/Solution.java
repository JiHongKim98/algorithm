/*
 * 프로그래머스 - 문자열 내 마음대로 정렬하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12915
 */
package Lv_1.문자열_내_마음대로_정렬하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> map = new ArrayList<>();

        for (String s : strings) map.add(s.charAt(n) + s);

        Collections.sort(map);

        String[] answer = new String[strings.length];
        for (int i = 0; i < strings.length; i++) answer[i] = map.get(i).substring(1);

        return answer;
    }
}
