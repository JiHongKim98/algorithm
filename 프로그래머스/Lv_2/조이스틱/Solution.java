/*
 * 프로그래머스 - 조이스틱
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */
package Lv_2.조이스틱;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int moving = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') next++;  // 연속된 'A'

            int backMoving = name.length() + i - next + Math.min(i, name.length() - next);
            moving = Math.min(moving, backMoving);
        }

        answer += moving;

        return answer;
    }
}
