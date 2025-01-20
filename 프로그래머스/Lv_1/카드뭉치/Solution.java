/*
 * 프로그래머스 - 카드 뭉치
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/159994
 */
package Lv_1.카드뭉치;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1Point = 0;
        int card2Point = 0;

        for (String target : goal) {

            if (card1Point < cards1.length && cards1[card1Point].equals(target)) {
                card1Point++;
                continue;
            }

            if (card2Point < cards2.length && cards2[card2Point].equals(target)) {
                card2Point++;
                continue;
            }

            return "No";
        }

        return "Yes";
    }
}
