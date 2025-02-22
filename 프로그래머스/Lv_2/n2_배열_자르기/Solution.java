/*
 * 프로그래머스 - n^2 배열 자르기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 */
package Lv_2.n2_배열_자르기;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        int seq = 0;
        for (long i = left; i <= right; i++) {
            int col = (int) (i % n);
            int row = (int) (i / n);

            if (row < col) answer[seq++] = col + 1;
            else answer[seq++] = row + 1;
        }

        return answer;
    }
}
