/*
 * 프로그래머스 - 땅따먹기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */
package Lv_2.땅따먹기;

class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            land[i][0] += getMax(land[i - 1], 0);
            land[i][1] += getMax(land[i - 1], 1);
            land[i][2] += getMax(land[i - 1], 2);
            land[i][3] += getMax(land[i - 1], 3);
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }
        return answer;
    }

    private int getMax(int[] curr, int index) {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            if (i == index) continue;
            temp = Math.max(curr[i], temp);
        }
        return temp;
    }
}
