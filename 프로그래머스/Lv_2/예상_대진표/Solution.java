/*
 * 프로그래머스 - 예상 대진표
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */
package Lv_2.예상_대진표;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
}
