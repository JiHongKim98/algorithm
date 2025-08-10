/*
 * 프로그래머스 - n + 1 카드게임
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/258707
 */
package Lv_3.N_더하기_일_카드게임;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int NUM;

    public int solution(int coin, int[] cards) {
        NUM = cards.length + 1;

        List<Integer> curr = new ArrayList<>();
        List<Integer> spare = new ArrayList<>();

        for (int i = 0; i < cards.length / 3; i++) curr.add(cards[i]);

        int answer = 1;
        for (int i = cards.length / 3; i < cards.length; i += 2) {
            spare.add(cards[i]);
            spare.add(cards[i + 1]);

            if (check(curr, curr)) {
                answer++;
            } else if (coin >= 1 && check(curr, spare)) {
                answer++;
                coin--;
            } else if (coin >= 2 && check(spare, spare)) {
                answer++;
                coin -= 2;
            } else {
                break;
            }
        }

        return answer;
    }

    private boolean check(List<Integer> aList, List<Integer> bList) {
        for (int a : aList) {
            int remain = NUM - a;

            if (bList.contains(remain)) {
                aList.remove(Integer.valueOf(a));
                bList.remove(Integer.valueOf(remain));
                return true;
            }
        }
        return false;
    }
}
