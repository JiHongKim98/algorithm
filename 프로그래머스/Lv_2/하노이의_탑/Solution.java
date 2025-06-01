/*
 * 프로그래머스 - 하노이의 탑
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 */
package Lv_2.하노이의_탑;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<int[]> moveMap = new ArrayList<>();

    public int[][] solution(int n) {
        DFS(n, 1, 3, 2);  // n을 1 에서 3 으로 이동

        return moveMap.toArray(new int[moveMap.size()][2]);
    }

    private void DFS(int curr, int from, int to, int temp) {
        if (curr == 1) {
            moveMap.add(new int[]{from, to});
        } else {
            DFS(curr - 1, from, temp, to);  // 현재 숫자보다 작은 탑을 temp 로 이동
            moveMap.add(new int[]{from, to});  // 현재 숫자 이동
            DFS(curr - 1, temp, to, from);  // temp 로 이동한 숫자를 목표지점으로 이동
        }
    }
}
