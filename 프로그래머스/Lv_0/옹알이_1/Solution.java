/*
 * 프로그래머스 - 옹알이 (1)
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120956
 */
package Lv_0.옹알이_1;

class Solution {

    private String[] map = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;

        for (String b : babbling) {
            for (String s : map) {
                b = b.replaceAll(s, " ");
            }

            if (b.trim().equals("")) answer++;
        }

        return answer;
    }
}
