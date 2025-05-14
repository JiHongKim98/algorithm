/*
 * 프로그래머스 - 몸짱 트레이너 라이언의 고민
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1838
 */
package Lv_3.몸짱_트레이너_라이언의_고민;

import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] timetable) {
        Arrays.sort(timetable, (o1, o2) -> o1[0] - o2[0]);

        Queue<Integer> queue = new PriorityQueue<>();

        int people = 1;
        for (int[] table : timetable) {
            while (!queue.isEmpty() && queue.peek() < table[0]) queue.poll();

            queue.add(table[1]);

            people = Math.max(people, queue.size());
        }

        if (people == 1) return 0;

        for (int i = (n - 1) * 2; i >= 1; i--) {
            if (isValid(n, people, i)) return i;
        }
        return -1;
    }

    private boolean isValid(int n, int people, int dist) {
        for (int start = 0; start < n; start++) {
            List<int[]> map = new ArrayList<>();

            for (int x = 0; x < n; x++) {
                loop:
                for (int y = 0; y < n; y++) {
                    if (x == 0 && y < start) continue loop;

                    for (int[] pos : map) {
                        int currDist = Math.abs(x - pos[0]) + Math.abs(y - pos[1]);
                        if (currDist < dist) continue loop;
                    }

                    map.add(new int[]{x, y});

                    if (map.size() == people) return true;
                }
            }
        }

        return false;
    }
}
