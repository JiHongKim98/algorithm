/*
 * 프로그래머스 - 줄 서는 방법
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12936
 */
package Lv_2.줄_서는_방법;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        k--;

        List<Integer> numMap = new ArrayList<>();
        for (int i = 1; i <= n; i++) numMap.add(i);

        int[] answer = new int[n];
        long currFac = factorial(n - 1);
        for (int i = n - 1; i > 0; i--) {
            answer[n - 1 - i] = numMap.remove((int) (k / currFac));

            k %= currFac;
            currFac /= i;
        }

        answer[n - 1] = numMap.remove(0);
        return answer;
    }

    private long factorial(int currNum) {
        if (currNum == 1) return 1L;
        return currNum * factorial(currNum - 1);
    }
}
