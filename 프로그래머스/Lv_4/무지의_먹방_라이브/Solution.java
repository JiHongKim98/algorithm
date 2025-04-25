/*
 * 프로그래머스 - 무지의 먹방 라이브
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42891
 */
package Lv_4.무지의_먹방_라이브;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] food_times, long k) {
        List<Integer> map = new ArrayList<>();
        for (int time : food_times) map.add(time);
        Collections.sort(map);

        int currMaxTime = 0;
        int foodCount = food_times.length;
        for (int currTime : map) {
            long timeDiff = (long) (currTime - currMaxTime) * foodCount;

            if (timeDiff <= k) {
                k -= timeDiff;
                currMaxTime = currTime;
                foodCount--;
            } else {
                k %= foodCount;
                break;
            }
        }

        for (int i = 0; i < food_times.length; i++) {
            if (food_times[i] <= currMaxTime) continue;

            if (k == 0) return i + 1;
            else k--;
        }

        return -1;
    }
}
