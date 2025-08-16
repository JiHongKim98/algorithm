/*
 * 프로그래머스 - 주사위 게임 3
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181916
 */
package Lv_0.주사위_게임_3;

import java.util.*;

class Solution {
    public int sol(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);

        int size = map.size();

        if (size == 1) {
            return 1111 * arr[0];
        } else if (size == 2) {
            for (int key : map.keySet()) {
                int count = map.get(key);
                if (count == 3) {
                    int p = key;
                    int q = 0;
                    for (int k : map.keySet()) {
                        if (k != p) {
                            q = k;
                            break;
                        }
                    }
                    return (int) Math.pow((10 * p + q), 2);
                } else if (count == 2) {
                    List<Integer> keys = new ArrayList<>(map.keySet());
                    int p = keys.get(0);
                    int q = keys.get(1);
                    return (p + q) * Math.abs(p - q);
                }
            }
        } else if (size == 3) {
            int pair = 0;
            List<Integer> singles = new ArrayList<>();
            for (int key : map.keySet()) {
                int count = map.get(key);
                if (count == 2) pair = key;
                else singles.add(key);
            }
            return singles.get(0) * singles.get(1);
        } else {
            return Arrays.stream(arr).min().getAsInt();
        }

        return -1;
    }

    public int solution(int a, int b, int c, int d) {
        return sol(new int[]{a, b, c, d});
    }
}
