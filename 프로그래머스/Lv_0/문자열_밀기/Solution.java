/*
 * 프로그래머스 - 문자열 밀기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120921
 */
package Lv_0.문자열_밀기;

class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.equals(B)) return answer;

            A = A.substring(A.length() - 1) + A.substring(0, A.length() - 1);
            answer += 1;
        }

        return -1;
    }
}
