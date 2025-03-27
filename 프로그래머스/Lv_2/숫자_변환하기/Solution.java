/*
 * 프로그래머스 - 숫자 변환하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538
 */
package Lv_2.숫자_변환하기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x + n, 1});
        queue.add(new int[]{x * 2, 1});
        queue.add(new int[]{x * 3, 1});

        boolean[] visit = new boolean[y + 1];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (poll[0] > y || visit[poll[0]]) continue;
            else visit[poll[0]] = true;

            if (poll[0] == y) return poll[1];

            queue.add(new int[]{poll[0] + n, poll[1] + 1});
            queue.add(new int[]{poll[0] * 2, poll[1] + 1});
            queue.add(new int[]{poll[0] * 3, poll[1] + 1});
        }

        return -1;
    }
}
