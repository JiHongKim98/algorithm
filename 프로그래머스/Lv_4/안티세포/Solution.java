/*
 * 프로그래머스 - 안티세포
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/86054
 */
package Lv_4.안티세포;

import java.util.*;

class Solution {

    private int MOD = (int) Math.pow(10, 9) + 7;

    public int[] solution(int[] a, int[] s) {
        int[] answer = new int[s.length];

        int idx = 0;
        for (int i = 0; i < s.length; i++) {
            int size = s[i];
            int[] array = Arrays.copyOfRange(a, idx, idx + size);

            List<Map<Long, Integer>> map = new ArrayList<>();
            for (int j = 0; j <= size; j++) map.add(new HashMap<>());

            long[] sumMap = new long[size + 1];
            sumMap[0] = 1;

            for (int currIdx = 1; currIdx <= size; currIdx++) {
                int leftIdx = currIdx - 1;
                long leftNum = array[leftIdx];

                long sum = 0;
                while (true) {
                    sum += sumMap[leftIdx];
                    sum %= MOD;

                    if (!map.get(currIdx).containsKey(leftNum)) map.get(currIdx).put(leftNum, leftIdx);

                    if (!map.get(leftIdx).containsKey(leftNum)) break;

                    leftIdx = map.get(leftIdx).get(leftNum);
                    leftNum *= 2;
                }

                map.get(currIdx).put((long) array[currIdx - 1], currIdx - 1);
                sumMap[currIdx] = sum;
            }

            answer[i] = (int) sumMap[size] % MOD;

            idx += size;
        }

        return answer;
    }
}
