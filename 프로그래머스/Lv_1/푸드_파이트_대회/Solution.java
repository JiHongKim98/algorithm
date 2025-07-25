/*
 * 프로그래머스 - 푸드 파이트 대회
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/134240
 */
package Lv_1.푸드_파이트_대회;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }

        return sb.toString() + "0" + sb.reverse();
    }
}
