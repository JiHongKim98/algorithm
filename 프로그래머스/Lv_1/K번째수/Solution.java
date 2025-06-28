/*
 * 프로그래머스 - K번째수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
package Lv_1.K번째수;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];

            int idx = 0;
            int[] clone = new int[command[1] - command[0] + 1];
            for (int j = command[0] - 1; j <= command[1] - 1; j++) clone[idx++] = array[j];

            Arrays.sort(clone);
            answer[i] = clone[command[2] - 1];
        }

        return answer;
    }
}
