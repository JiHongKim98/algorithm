/*
 * 프로그래머스 - 점프와 순간 이동
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */
package Lv_2.점프와_순간_이동;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            if (n % 2 != 0) ans++;
            n /= 2;
        }

        return ans;
    }
}
