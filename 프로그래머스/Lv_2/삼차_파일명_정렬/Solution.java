/*
 * 프로그래머스 - [3차] 파일명 정렬
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17686
 */
package Lv_2.삼차_파일명_정렬;

import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String o1Head = o1.split("\\d")[0].toUpperCase();
            int o1Number = Integer.parseInt(o1.substring(o1Head.length()).split("\\D+")[0]);

            String o2Head = o2.split("\\d")[0].toUpperCase();
            int o2Number = Integer.parseInt(o2.substring(o2Head.length()).split("\\D+")[0]);

            int result = o1Head.compareTo(o2Head);
            if (result != 0) return result;
            else return o1Number - o2Number;
        });
        return files;
    }
}
