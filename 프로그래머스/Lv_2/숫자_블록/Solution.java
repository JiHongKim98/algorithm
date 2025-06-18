/*
 * 프로그래머스 - 숫자 블록
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12923
 */
package Lv_2.숫자_블록;

class Solution {
    public int[] solution(long begin, long end) {
        int size = (int) (end - begin + 1);

        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            int curr = (int) begin + i;

            if (curr == 1) {
                answer[i] = 0;
                continue;
            }

            int max = 1;
            for (int j = 2; j <= Math.sqrt(curr); j++) {
                if (curr % j == 0) {
                    int div = curr / j;

                    if (div <= 10_000_000) {
                        max = div;
                        break;
                    } else {
                        max = j;
                    }
                }
            }

            answer[i] = max;
        }
        return answer;
    }
}
