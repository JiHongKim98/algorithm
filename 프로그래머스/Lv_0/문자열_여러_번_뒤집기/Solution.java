/*
 * 프로그래머스 - 문자열 여러 번 뒤집기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181913
 */
package Lv_0.문자열_여러_번_뒤집기;

class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] arr = my_string.toCharArray();

        for (int[] q : queries) {
            int sIdx = q[0];
            int eIdx = q[1];

            while (sIdx < eIdx) {
                char mem = arr[sIdx];
                arr[sIdx++] = arr[eIdx];
                arr[eIdx--] = mem;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char a : arr) sb.append(a);

        return sb.toString();
    }
}
