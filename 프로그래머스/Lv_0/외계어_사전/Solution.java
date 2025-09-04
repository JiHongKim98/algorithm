/*
 * 프로그래머스 - 외계어 사전
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120869
 */
package Lv_0.외계어_사전;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int sLen = spell.length;
        loop:
        for (String d : dic) {
            if (d.length() < sLen) continue;

            for (String s : spell) {
                if (!d.contains(s)) continue loop;
            }

            return 1;
        }

        return 2;
    }
}
