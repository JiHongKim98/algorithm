/*
 * 프로그래머스 - 치킨 쿠폰
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120884
 */
package Lv_0.치킨_쿠폰;

class Solution {
    public int solution(int chicken) {
        int answer = 0;

        while (chicken >= 10) {
            int service = chicken / 10;
            answer += service;
            chicken = chicken % 10 + service;
        }

        return answer;
    }
}
