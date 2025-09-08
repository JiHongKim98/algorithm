/*
 * 프로그래머스 - 정사각형으로 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181830
 */
package Lv_0.정사각형으로_만들기;

class Solution {
    public int[][] solution(int[][] arr) {
        int col = arr.length;
        int row = arr[0].length;
        int max = Math.max(col, row);

        int[][] answer = new int[max][max];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                answer[i][j] = i < col && j < row ? arr[i][j] : 0;
            }
        }

        return answer;
    }
}
