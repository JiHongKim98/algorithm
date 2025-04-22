/*
 * 프로그래머스 - 마법의 엘리베이터
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653
 */
package Lv_2.마법의_엘리베이터;

class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int curr = storey % 10;
            int next = (storey / 10) % 10;

            if (curr > 5 || (curr == 5 && next >= 5)) {
                answer += (10 - curr);
                storey += 10;
            } else {
                answer += curr;
            }

            storey /= 10;
        }
        return answer;
    }
}
