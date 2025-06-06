/*
 * 프로그래머스 - 혼자 놀기의 달인
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131130
 */
package Lv_2.혼자_놀기의_달인;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] cards) {
        boolean[] visit = new boolean[cards.length];
        List<Integer> map = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (visit[i]) continue;

            int curr = i;
            int count = 0;
            while (!visit[curr]) {
                visit[curr] = true;
                curr = cards[curr] - 1;
                count++;
            }

            map.add(count);
        }

        map.sort(Collections.reverseOrder());

        if (map.size() < 2) return 0;
        return map.get(0) * map.get(1);
    }
}
