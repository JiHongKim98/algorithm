/*
 * 프로그래머스 - 지폐 접기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/340199
 */
package Lv_1.지폐접기;

import java.util.Arrays;

class Solution {
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        Arrays.sort(wallet);
        Arrays.sort(bill);

        while (bill[0] > wallet[0] || bill[1] > wallet[1]) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }

            Arrays.sort(wallet);
            Arrays.sort(bill);

            answer++;
        }

        return answer;
    }
}
