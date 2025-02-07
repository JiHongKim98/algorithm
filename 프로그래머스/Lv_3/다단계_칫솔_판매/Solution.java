/*
 * 프로그래머스 - 다단계 칫솔 판매
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/77486
 */
package Lv_3.다단계_칫솔_판매;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> pointMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            pointMap.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            String currentSell = seller[i];
            int money = amount[i] * 100;

            while (!currentSell.equals("-") && money > 0) {
                int parentMoney = money / 10;
                int myMoney = money - parentMoney;

                pointMap.put(currentSell, pointMap.get(currentSell) + myMoney);

                currentSell = parentMap.get(currentSell);
                money = parentMoney;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = pointMap.get(enroll[i]);
        }

        return answer;
    }
}
