/*
 * 프로그래머스 - 최고의 집합
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12938
 */
package Lv_3.최고의_집합;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};

        int middle = s / n;
        int remain = s % n;

        int[] answer = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (remain != 0) {
                remain--;
                answer[i] = middle + 1;
            } else {
                answer[i] = middle;
            }
        }

        return answer;
    }
}
