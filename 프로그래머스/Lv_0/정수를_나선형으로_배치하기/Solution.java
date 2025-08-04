/*
 * 프로그래머스 - 정수를 나선형으로 배치하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181832
 */
package Lv_0.정수를_나선형으로_배치하기;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int num = 1;

        int rowS = 0;
        int rowE = n - 1;
        int colS = 0;
        int colE = n - 1;
        while (num <= Math.pow(n, 2)) {
            for (int i = colS; i <= colE; i++) answer[rowS][i] = num++;
            rowS++;

            for (int i = rowS; i <= rowE; i++) answer[i][colE] = num++;
            colE--;

            for (int i = colE; i >= colS; i--) answer[rowE][i] = num++;
            rowE--;

            for (int i = rowE; i >= rowS; i--) answer[i][colS] = num++;
            colS++;
        }

        return answer;
    }
}
