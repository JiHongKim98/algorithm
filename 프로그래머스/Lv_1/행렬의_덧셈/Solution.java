/*
 * 프로그래머스 - 행렬의 덧셈
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12950
 */
package Lv_1.행렬의_덧셈;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
