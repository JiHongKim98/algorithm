/*
 * 프로그래머스 - 수식 복원하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/340210
 */
package Lv_3.수식_복원하기;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    private static int maxValue = 2;
    private static boolean[] isPossible = new boolean[10];

    public String[] solution(String[] expressions) {
        Arrays.fill(isPossible, true);

        ArrayList<String> xAnswer = new ArrayList<>();

        for (String current : expressions) {
            String[] splitCurrent = current.split(" ");

            int[] aList = calMaxNum(splitCurrent[0]);
            int[] bList = calMaxNum(splitCurrent[2]);
            if (!splitCurrent[4].equals("X")) {
                int[] cList = calMaxNum(splitCurrent[4]);

                for (int j = maxValue; j < 10; j++) {
                    if (!isPossible[j]) {
                        break;
                    }

                    int targetResult = 0;
                    int w = aList.length - 1;
                    for (int k = 0; k < aList.length; k++) {
                        targetResult += aList[k] * Math.pow(j, w);
                        w--;
                    }

                    w = bList.length - 1;
                    if (splitCurrent[1].equals("+")) {
                        for (int k = 0; k < bList.length; k++) {
                            targetResult += bList[k] * Math.pow(j, w);
                            w--;
                        }
                    } else {
                        for (int k = 0; k < bList.length; k++) {
                            targetResult -= bList[k] * Math.pow(j, w);
                            w--;
                        }
                    }

                    int expectedValue = 0;
                    w = cList.length - 1;
                    for (int k = 0; k < cList.length; k++) {
                        expectedValue += cList[k] * Math.pow(j, w);
                        w--;
                    }

                    if (targetResult != expectedValue) {
                        isPossible[j] = false;
                    }
                }

            } else {
                xAnswer.add(current);
            }
        }

        String[] answer = new String[xAnswer.size()];

        for (int i = 0; i < xAnswer.size(); i++) {

            String current = xAnswer.get(i);

            String[] splitCurrent = current.split(" ");

            int temp = -1;
            boolean flag = true;

            for (int j = 2; j < 10; j++) {
                if (!isPossible[j] || !flag) continue;

                int[] aList = calMaxNum(splitCurrent[0]);
                int[] bList = calMaxNum(splitCurrent[2]);

                int targetResult = 0;
                int w = aList.length - 1;
                for (int k = 0; k < aList.length; k++) {
                    targetResult += aList[k] * Math.pow(j, w);
                    w--;
                }

                w = bList.length - 1;
                if (splitCurrent[1].equals("+")) {
                    for (int k = 0; k < bList.length; k++) {
                        targetResult += bList[k] * Math.pow(j, w);
                        w--;
                    }
                } else {
                    for (int k = 0; k < bList.length; k++) {
                        targetResult -= bList[k] * Math.pow(j, w);
                        w--;
                    }
                }

                int target = convertToDecimal(targetResult, j);

                if (temp != -1 && temp != target) {
                    temp = -1;
                    flag = false;
                } else {
                    temp = target;
                }
            }

            if (temp == -1) {
                answer[i] = splitCurrent[0] + " " + splitCurrent[1] + " " + splitCurrent[2] + " " + splitCurrent[3] + " ?";
            } else {
                answer[i] = splitCurrent[0] + " " + splitCurrent[1] + " " + splitCurrent[2] + " " + splitCurrent[3] + " " + temp;
            }
        }

        return answer;
    }

    private int[] calMaxNum(String stringNum) {
        int[] results = splitNumber(stringNum);

        for (int i = 0; i < results.length; i++) {
            maxValue = Math.max(maxValue, results[i] + 1);
        }

        for (int j = 0; j < maxValue; j++) {
            isPossible[j] = false;
        }

        return results;
    }

    private int[] splitNumber(String stringNum) {
        int[] results = new int[stringNum.length()];

        String[] split = stringNum.split("");

        for (int i = 0; i < stringNum.length(); i++) {
            results[i] = Integer.parseInt(split[i]);
        }

        return results;
    }

    private int convertToDecimal(int number, int base) {
        int result = 0;
        int power = 1;

        while (number > 0) {
            int digit = number % base;
            result += digit * power;
            number /= base;
            power *= 10;
        }

        return result;
    }
}
