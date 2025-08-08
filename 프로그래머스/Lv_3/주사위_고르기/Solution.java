/*
 * 프로그래머스 - 주사위 고르기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/258709
 */
package Lv_3.주사위_고르기;

import java.util.Arrays;

class Solution {
    public int[] solution(int[][] dice) {
        int len = dice.length;

        int maxCount = Integer.MIN_VALUE;

        int[] answer = new int[len / 2];
        int[] diceIdxA = new int[len / 2];
        int[] diceIdxB = new int[len / 2];

        for (int mask = 0; mask < (1 << len); mask++) {
            if (Integer.bitCount(mask) != len / 2) continue;

            int ai = 0, bi = 0;
            for (int i = 0; i < len; i++) {
                if ((mask & (1 << i)) != 0) diceIdxA[ai++] = i;
                else diceIdxB[bi++] = i;
            }

            int[] aSum = getSum(diceIdxA, dice);
            int[] bSum = getSum(diceIdxB, dice);

            Arrays.sort(bSum);

            int count = 0;
            for (int a : aSum) {
                int left = 0, right = bSum.length;
                while (left < right) {
                    int mid = (left + right) / 2;

                    if (bSum[mid] < a) left = mid + 1;
                    else right = mid;
                }
                count += left;
            }

            if (count > maxCount) {
                int idx = 0;
                for (int i = 0; i < len; i++) {
                    if ((mask & (1 << i)) != 0) answer[idx++] = i + 1;
                }

                maxCount = count;
            }
        }
        return answer;
    }

    private int[] getSum(int[] diceIdx, int[][] dice) {
        int[] sum = {0};
        for (int idx : diceIdx) {
            int[] next = new int[sum.length * 6];
            int nextIdx = 0;
            for (int s : sum) {
                for (int d : dice[idx]) next[nextIdx++] = s + d;
            }
            sum = next;
        }
        return sum;
    }
}
