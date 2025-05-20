/*
 * 프로그래머스 - 124 나라의 숫자
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12899
 */
package Lv_2.일이사_나라의_숫자;

class Solution {
    public String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        while (n > 0) {
            int curr = n % 3;

            if (curr == 0) {
                stringBuilder.append("4");
                n = (n / 3) - 1;
            } else {
                stringBuilder.append(curr);
                n /= 3;
            }
        }

        return stringBuilder.reverse().toString();
    }
}
