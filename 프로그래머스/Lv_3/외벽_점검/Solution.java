/*
 * 프로그래머스 - 외벽 점검
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/60062
 */
package Lv_3.외벽_점검;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private int len;
    private int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        len = weak.length;
        int[] extendWeak = new int[len * 2];

        for (int i = 0; i < len; i++) {
            extendWeak[i] = weak[i];
            extendWeak[i + len] = weak[i] + n;
        }

        Arrays.sort(dist);

        List<int[]> distMap = new ArrayList<>();
        dfs(dist, 0, distMap);  // 모든 사용자 순열 생성

        for (int start = 0; start < len; start++) {
            for (int[] currDist : distMap) {
                check(extendWeak, currDist, start);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int[] dist, int start, List<int[]> distMap) {
        if (start == dist.length) {
            distMap.add(dist.clone());
            return;
        }

        for (int i = start; i < dist.length; i++) {
            swapOrder(dist, start, i);

            dfs(dist, start + 1, distMap);

            swapOrder(dist, start, i);
        }
    }

    private void swapOrder(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void check(int[] extendedWeak, int[] currDist, int start) {
        int count = 0;
        int end = start + len;

        for (int curr : currDist) {
            count++;

            int limit = extendedWeak[start] + curr;

            while (start < end && extendedWeak[start] <= limit) {
                start++;
            }

            if (start >= end) {
                answer = Math.min(answer, count);
                return;
            }
        }
    }
}
