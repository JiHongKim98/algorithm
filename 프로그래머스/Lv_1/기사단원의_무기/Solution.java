/*
 * 프로그래머스 - 기사단원의 무기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/136798
 */
package Lv_1.기사단원의_무기;

class Solution {
    public int solution(int number, int limit, int power) {
        int[] map = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            double sqrt = Math.sqrt(i);

            int count = 0;
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) count++;
            }

            if (sqrt % 1 == 0) count = count * 2 - 1;
            else count = count * 2;

            if (count > limit) map[i] = power;
            else map[i] = count;
        }

        int answer = 0;
        for (int num : map) answer += num;

        return answer;
    }
}
