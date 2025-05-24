/*
 * 프로그래머스 - 디펜스 게임
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/142085
 */
package Lv_2.디펜스_게임;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            queue.add(enemy[i]);
            n -= enemy[i];

            if (n < 0) {
                if (k > 0) {
                    n += queue.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }

        return enemy.length;
    }
}
