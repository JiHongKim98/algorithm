/*
 * 프로그래머스 - [1차] 뉴스 클러스터링
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 */
package Lv_2.뉴스_클러스터링;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        List<String> map1 = new ArrayList<>();
        List<String> map2 = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 1; i < str1.length(); i++) {
            char c1 = str1.charAt(i - 1);
            char c2 = str1.charAt(i);
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                map1.add("" + c1 + c2);
            }
        }

        for (int i = 1; i < str2.length(); i++) {
            char c1 = str2.charAt(i - 1);
            char c2 = str2.charAt(i);
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                map2.add("" + c1 + c2);
            }
        }

        int 교 = 0;
        for (String s : map1) {
            if (map2.contains(s)) {
                교++;
                map2.remove(s);
            }
        }

        int 합 = map1.size() + map2.size();

        if (합 == 0) return 65536;
        return 교 * 65536 / 합;
    }
}
