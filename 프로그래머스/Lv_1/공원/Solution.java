/*
 * 프로그래머스 - 공원
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/340198
 */
package Lv_1.공원;

import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        Arrays.sort(mats);

        int row = park.length;
        int col = park[0].length;

        for (int i = mats.length - 1; i >= 0; i--) {
            for (int r = 0; r <= row - mats[i]; r++) {
                for (int c = 0; c <= col - mats[i]; c++) {

                    boolean check = true;

                    for (int x = r; x < mats[i] + r; x++) {
                        for (int y = c; y < mats[i] + c; y++) {
                            if (!park[x][y].equals("-1")) {
                                check = false;
                                break;
                            }
                        }

                        if (!check) break;
                    }

                    if (check) return mats[i];
                }
            }
        }

        return answer;
    }
}
