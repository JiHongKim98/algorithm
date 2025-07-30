/*
 * 프로그래머스 - 최대공약수와 최소공배수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12940
 */
package Lv_1.최대공약수와_최소공배수;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int a = Math.max(n, m);
        int b = Math.min(n, m);

        int temp = -1;
        while (b > 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        answer[0] = a;
        answer[1] = n * m / a;

        return answer;
    }
}
