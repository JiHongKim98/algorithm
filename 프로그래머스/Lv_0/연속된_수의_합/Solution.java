/*
 * 프로그래머스 - 연속된 수의 합
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120923
 */
package Lv_0.연속된_수의_합;

class Solution {
    public int[] solution(int num, int total) {

        int sum = 0;
        int idx = num - 1;
        while (idx >= 1) {
            sum += idx;
            idx--;
        }

        total -= sum;
        int a = total / num;

        int[] answer = new int[num];
        for (int i = 0; i < num; i++) answer[i] = a++;

        return answer;
    }
}
