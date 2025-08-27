/*
 * 프로그래머스 - 다항식 더하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120863
 */
package Lv_0.다항식_더하기;

class Solution {
    public String solution(String polynomial) {
        String[] split = polynomial.split(" +");

        int xxx = 0;
        int num = 0;
        for (String s : split) {
            if (s.equals("x")) xxx += 1;
            else if (s.contains("x")) xxx += Integer.parseInt(s.replace("x", ""));
            else if (!s.equals("+")) num += Integer.parseInt(s);
        }

        String answer = "";
        if (xxx == 0 && num != 0) {
            answer = String.valueOf(num);
        } else if (xxx != 0 && num == 0) {
            if (xxx == 1) answer = "x";
            else answer = xxx + "x";
        } else if (xxx == 1) {
            answer = "x" + " + " + num;
        } else {
            answer = xxx + "x" + " + " + num;
        }

        return answer;
    }
}
