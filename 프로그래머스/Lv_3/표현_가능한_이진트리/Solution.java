/*
 * 프로그래머스 - 표현 가능한 이진트리
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/150367
 */
package Lv_3.표현_가능한_이진트리;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = convertToBinary(numbers[i]);

            if (check(binary, 0, binary.length() - 1)) answer[i] = 1;
            else answer[i] = 0;
        }

        return answer;
    }

    private String convertToBinary(long num) {
        String temp = Long.toBinaryString(num);

        int nodeSize = 1;
        while (nodeSize - 1 < temp.length()) nodeSize *= 2;

        return "0".repeat(nodeSize - temp.length() - 1) + temp;
    }

    private boolean check(String binary, int start, int end) {
        if (end < start) return true;

        int mid = (start + end) / 2;

        if (binary.charAt(mid) == '0') {
            for (int i = start; i <= end; i++) {
                if (binary.charAt(i) == '1') return false;
            }
        }

        return check(binary, start, mid - 1) && check(binary, mid + 1, end);
    }
}
