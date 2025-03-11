/*
 * 프로그래머스 - 주식가격
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */
package Lv_2.주식가격;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int k = prices[i];

            for (int j = i; j < prices.length; j++) {
                if (k > prices[j]) {
                    answer[i] = j - i;
                    break;
                }

                if (j == prices.length - 1) answer[i] = j - i;
            }
        }

        return answer;
    }
}
