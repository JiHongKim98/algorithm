/*
 * 프로그래머스 - 크기가 작은 부분 문자열
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/147355
 */
package Lv_1.크기가_작은_부분_문자열;

class Solution {
    public int solution(String t, String p) {
        long targetNum = Long.parseLong(p);

        long pow = (long) Math.pow(10, p.length() - 1);

        int answer = 0;
        long currNum = 0L;
        if (p.length() != 1) currNum = Long.parseLong(t.substring(0, p.length() - 1));

        for (int i = p.length() - 1; i < t.length(); i++) {
            int add = Integer.parseInt(t.substring(i, i + 1));
            currNum = currNum * 10 + add;

            if (currNum <= targetNum) answer++;

            currNum -= (currNum / pow) * pow;
        }

        return answer;
    }
}
