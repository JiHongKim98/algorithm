/*
 * 프로그래머스 - 시저 암호
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12926
 */
package Lv_1.시저_암호;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == ' ') sb.append(" ");
            else if (Character.isLowerCase(curr)) sb.append(convert(curr, 'a', 'z', n));
            else sb.append(convert(curr, 'A', 'Z', n));
        }

        return sb.toString();
    }

    private char convert(char curr, char min, char max, int move) {
        return curr + move > max ? (char) (min + curr + move - max - 1) : (char) (curr + move);
    }
}
