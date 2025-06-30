/*
 * 프로그래머스 - [1차] 비밀지도
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17681
 */
package Lv_1.일차_비밀지도;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String bin1 = format(Integer.toBinaryString(arr1[i]), n);
            String bin2 = format(Integer.toBinaryString(arr2[i]), n);

            String curr = "";
            for (int j = 0; j < n; j++) {
                if (bin1.charAt(j) == '1' || bin2.charAt(j) == '1') curr += "#";
                else curr += " ";
            }
            answer[i] = curr;
        }

        return answer;
    }

    private String format(String bin, int n) {
        if (bin.length() == n) return bin;
        return "0".repeat(n - bin.length()) + bin;
    }
}
