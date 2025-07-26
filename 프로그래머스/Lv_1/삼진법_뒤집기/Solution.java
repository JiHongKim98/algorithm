/*
 * 프로그래머스 - 3진법 뒤집기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/68935
 */
package Lv_1.삼진법_뒤집기;

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        return Integer.parseInt(sb.toString(), 3);
    }
}
