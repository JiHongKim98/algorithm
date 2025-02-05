/*
 * 프로그래머스 - 디스크 컨트롤러
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
package Lv_3.디스크_컨트롤러;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int remainJobs = jobs.length;
        int currentTime = 0;
        int sequence = 0;

        while (remainJobs > 0) {
            if (queue.isEmpty()) {
                currentTime = jobs[sequence][0];
            } else {
                int[] poll = queue.poll();
                answer += currentTime + poll[1] - poll[0];
                currentTime += poll[1];
                remainJobs--;
            }

            while (sequence < jobs.length && jobs[sequence][0] <= currentTime) {
                queue.add(jobs[sequence]);
                sequence++;
            }
        }

        return answer / jobs.length;
    }
}
