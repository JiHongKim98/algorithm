/*
 * 프로그래머스 - 점 찍기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/140107
 */
package Lv_2.점_찍기;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i += k) {
            answer += (long) Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2)) / k + 1;
        }

        return answer;
    }
}
