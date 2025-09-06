/*
 * 프로그래머스 - 전국 대회 선발 고사
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181851
 */
package Lv_0.전국_대회_선발_고사;

import java.util.PriorityQueue;

/**
 * PQ 풀이
 */
public class SolutionPQ {
    public int solution(int[] rank, boolean[] attendance) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i]) pq.add(new int[]{i, rank[i]});
        }

        return pq.poll()[0] * 10000 + pq.poll()[0] * 100 + pq.poll()[0];
    }
}
