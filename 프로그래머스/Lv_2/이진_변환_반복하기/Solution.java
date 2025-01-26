/*
 * 프로그래머스 - 이진 변환 반복하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
package Lv_2.이진_변환_반복하기;

class Solution {

    private static int count = 0;
    private static int processCount = 0;

    public int[] solution(String s) {
        while (!s.equals("1")) {
            s = process(s);
            processCount++;
        }

        return new int[]{processCount, count};
    }

    private String process(String num) {
        int currentCount = num.length();
        num = num.replace("0", "");

        int numLen = num.length();
        count += currentCount - numLen;

        return Integer.toBinaryString(numLen);
    }
}
