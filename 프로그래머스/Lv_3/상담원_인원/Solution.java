/*
 * 프로그래머스 - 상담원 인원
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/214288
 */
package Lv_3.상담원_인원;

import java.util.*;

class Solution {

    private Map<Integer, List<int[]>> reqMap = new HashMap<>();

    public int solution(int k, int n, int[][] reqs) {
        n -= k;

        for (int i = 1; i <= k; i++) reqMap.put(i, new ArrayList<>());
        for (int[] req : reqs) reqMap.get(req[2]).add(req);

        int[] personMap = new int[k + 1];
        for (int i = 1; i <= k; i++) personMap[i] = 1;

        int[] delayMap = new int[k + 1];
        for (int i = 1; i <= k; i++) delayMap[i] = getTime(i, personMap[i]);

        while (n-- > 0) {
            int tpye = 0;
            int maxDelay = Integer.MIN_VALUE;

            for (int i = 1; i <= k; i++) {
                int currDelay = delayMap[i] - getTime(i, personMap[i] + 1);

                if (currDelay > maxDelay) {
                    maxDelay = currDelay;
                    tpye = i;
                }
            }

            personMap[tpye]++;
            delayMap[tpye] = getTime(tpye, personMap[tpye]);
        }

        int answer = 0;
        for (int i = 1; i <= k; i++) answer += delayMap[i];
        return answer;
    }

    private int getTime(int type, int person) {
        int delayTime = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (o1, o2) -> (o1[0] + o1[1]) - (o2[0] + o2[1])
        );

        for (int[] curr : reqMap.get(type)) {
            if (queue.size() >= person) {
                int[] poll = queue.poll();
                int endTime = poll[0] + poll[1];

                if (curr[0] < endTime) {
                    delayTime += endTime - curr[0];
                    queue.add(new int[]{endTime, curr[1], curr[2]});
                    continue;
                }
            }

            queue.add(curr);
        }

        return delayTime;
    }
}
