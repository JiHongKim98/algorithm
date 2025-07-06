/*
 * 프로그래머스 - 약수의 개수와 덧셈
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/77884
 */
package Lv_1.약수의_개수와_덧셈;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int count = 0;

            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (j == Math.sqrt(i)) count++;
                    else count += 2;
                }
            }

            if (count % 2 == 0) answer += i;
            else answer -= i;
        }

        return answer;
    }
}
