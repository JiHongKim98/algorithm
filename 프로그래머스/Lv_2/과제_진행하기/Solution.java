/*
 * 프로그래머스 - 과제 진행하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/176962
 */
package Lv_2.과제_진행하기;

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (o1, o2) -> getTime(o1[1]) - getTime(o2[1]));

        List<String> answer = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        Map<String, int[]> cache = new HashMap<>();
        for (String[] p : plans) cache.put(p[0], new int[]{getTime(p[1]), Integer.parseInt(p[2])});

        int idx = 0;
        int now = cache.get(plans[0][0])[0];

        while (idx < plans.length) {
            String currName = plans[idx][0];
            int[] currTime = cache.get(currName);

            now = Math.max(now, currTime[0]);

            if (idx + 1 < plans.length) {
                String nextName = plans[idx + 1][0];
                int nextStart = cache.get(nextName)[0];
                int possibleTime = nextStart - now;

                if (currTime[1] <= possibleTime) {
                    answer.add(currName);
                    now += currTime[1];

                    while (!stack.isEmpty()) {
                        String pausedName = stack.pop();
                        int[] pausedTime = cache.get(pausedName);

                        if (pausedTime[1] <= nextStart - now) {
                            answer.add(pausedName);
                            now += pausedTime[1];
                        } else {
                            pausedTime[1] -= (nextStart - now);
                            stack.push(pausedName);
                            now = nextStart;
                            break;
                        }
                    }
                } else {
                    currTime[1] -= possibleTime;
                    stack.push(currName);
                    now = nextStart;
                }
            } else {
                answer.add(currName);
                while (!stack.isEmpty()) answer.add(stack.pop());
            }

            idx++;
        }

        return answer.toArray(new String[0]);
    }

    private int getTime(String timeStr) {
        String[] split = timeStr.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
