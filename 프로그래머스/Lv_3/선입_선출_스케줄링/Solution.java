/*
 * 프로그래머스 - 선입 선출 스케줄링
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12920
 */
package Lv_3.선입_선출_스케줄링;

class Solution {
    public int solution(int n, int[] cores) {
        if (n <= cores.length) return n;

        n -= cores.length; // 0초에 모든 core에 작업 할당

        int start = 1;
        int end = 10_000 * n + 1;

        int time = end;

        while (start <= end) {
            int mid = (start + end) / 2;

            long count = 0;
            for (int core : cores) {
                count += mid / core;
            }

            if (count >= n) {
                time = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        long pending = n;
        for (int core : cores) {
            pending -= (time - 1) / core; // 전체 완료 시간 직전까지 각 코어당 처리 가능한 개수 합
        }

        for (int i = 0; i < cores.length; i++) {
            if (time % cores[i] == 0) {
                pending--;
                if (pending == 0) return i + 1;
            }
        }
        return -1;
    }
}
