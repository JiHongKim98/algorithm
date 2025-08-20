/*
 * 프로그래머스 - OX퀴즈
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120907
 */
package Lv_0.OX퀴즈;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] q = quiz[i].split(" ");

            int num1 = Integer.parseInt(q[0]);
            int num2 = Integer.parseInt(q[2]);
            int exec = Integer.parseInt(q[4]);

            if (
                    (q[1].equals("+") && num1 + num2 == exec) ||
                            (q[1].equals("-") && num1 - num2 == exec)
            ) answer[i] = "O";
            else answer[i] = "X";
        }

        return answer;
    }
}
