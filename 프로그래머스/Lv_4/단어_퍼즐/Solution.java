/*
 * 프로그래머스 - 단어 퍼즐
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12983
 */
package Lv_4.단어_퍼즐;

import java.util.Arrays;

class Solution {
    public int solution(String[] strs, String t) {
        int[] dp = new int[t.length() + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= t.length(); i++) {
            for (String curr : strs) {
                if (i < curr.length()) continue;

                if (
                        t.startsWith(curr, i - curr.length()) &&
                                dp[i - curr.length()] != Integer.MAX_VALUE
                ) {
                    dp[i] = Math.min(dp[i], dp[i - curr.length()] + 1);
                }
            }
        }

        return dp[t.length()] == Integer.MAX_VALUE ? -1 : dp[t.length()];
    }
}
