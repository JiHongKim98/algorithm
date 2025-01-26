/*
 * 프로그래머스 - 2개 이하로 다른 비트
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/778859
 */
package Lv_2.두개_이하로_다른_비트;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];

            if (number % 2 == 0) {
                answer[i] = number + 1;
                continue;
            }

            String bNumber = Long.toBinaryString(number);
            StringBuilder sbNumber = new StringBuilder(bNumber);

            if (bNumber.contains("0")) {
                int idx = bNumber.lastIndexOf("0");
                sbNumber.setCharAt(idx, '1');
                sbNumber.setCharAt(idx + 1, '0');

                answer[i] = Long.parseLong(sbNumber.toString(), 2);
            } else {
                long w = (long) (Math.pow(2, bNumber.length() - 1));
                answer[i] = number + w;
            }
        }

        return answer;
    }
}
