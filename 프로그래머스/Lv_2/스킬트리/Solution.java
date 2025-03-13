/*
 * 프로그래머스 - 스킬트리
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/49993
 */
package Lv_2.스킬트리;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        List<Character> map = new ArrayList<>();
        for (int i = 0; i < skill.length(); i++) {
            map.add(skill.charAt(i));
        }

        for (String sk : skill_trees) {
            int idx = 0;
            for (int i = 0; i < sk.length(); i++) {
                char curr = sk.charAt(i);

                if (curr == map.get(idx)) idx++;
                else if (map.contains(curr)) break;

                if (idx == map.size() || i == sk.length() - 1) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
