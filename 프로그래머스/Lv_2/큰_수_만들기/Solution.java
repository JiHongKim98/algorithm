/*
 * 프로그래머스 - 큰 수 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */
package Lv_2.큰_수_만들기;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        for (char currChar : number.toCharArray()) {
            while (!answer.isEmpty() && answer.charAt(answer.length() - 1) < currChar && k > 0) {
                answer.deleteCharAt(answer.length() - 1);
                k--;
            }

            answer.append(currChar);
        }

        if (k > 0) {
            return answer.substring(0, answer.length() - k);
        }
        return answer.toString();
    }
}
