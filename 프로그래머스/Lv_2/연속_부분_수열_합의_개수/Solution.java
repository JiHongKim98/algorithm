/*
 * 프로그래머스 - 연속 부분 수열 합의 개수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */
package Lv_2.연속_부분_수열_합의_개수;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int[] answer = new int[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            answer[i] = elements[i];
            answer[i + elements.length] = elements[i];
        }

        int[] sumMap = new int[elements.length * 2 + 1];
        for (int i = 0; i < elements.length * 2; i++) {
            sumMap[i + 1] = sumMap[i] + answer[i];
        }

        Set<Integer> sumSet = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = sumMap[i + j] - sumMap[j];
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}
