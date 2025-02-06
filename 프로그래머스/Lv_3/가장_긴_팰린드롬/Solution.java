/*
 * 프로그래머스 - 가장 긴 팰린드롬
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12904
 */
package Lv_3.가장_긴_팰린드롬;

class Solution {
    public int solution(String s) {
        for (int maxLen = s.length(); maxLen > 0; maxLen--) {
            for (int start = 0; start + maxLen < s.length() + 1; start++) {
                if (isPossible(start, start + maxLen - 1, s)) {
                    return maxLen;
                }
            }
        }
        return -1;
    }

    public boolean isPossible(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
