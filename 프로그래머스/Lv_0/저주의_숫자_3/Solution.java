/*
 * 프로그래머스 - 저주의 숫자 3
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120871
 */
package Lv_0.저주의_숫자_3;

class Solution {
    public int solution(int n) {
        int count = 0;
        int answer = 0;

        while (count < n) {
            answer++;

            if (answer % 3 != 0 && !check(answer)) count++;
        }

        return answer;
    }

    private boolean check(int num) {
        while (num > 0) {
            if (num % 10 == 3) return true;
            num /= 10;
        }
        return false;
    }
}
