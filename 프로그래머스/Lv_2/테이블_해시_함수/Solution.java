/*
 * 프로그래머스 - 테이블 해시 함수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/147354
 */
package Lv_2.테이블_해시_함수;

import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) return o2[0] - o1[0];
            return o1[col - 1] - o2[col - 1];
        });

        int answer = -1;
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int sum = 0;
            for (int j = 0; j < data[i].length; j++) sum += data[i][j] % (i + 1);

            if (answer == -1) answer = sum;
            else answer ^= sum;
        }

        return answer;
    }
}
