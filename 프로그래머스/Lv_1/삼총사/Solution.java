/*
 * 프로그래머스 - 삼총사
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131705
 */
package Lv_1.삼총사;

class Solution {

    private int answer = 0;
    private int[] number;
    private boolean[] visit;

    public int solution(int[] number) {
        this.number = number;
        this.visit = new boolean[number.length];

        DFS(0, 0, 0);

        return answer;
    }

    private void DFS(int depth, int currIdx, int sum) {
        if (depth == 3) {
            if (sum == 0) answer++;
            return;
        }

        for (int i = currIdx; i < number.length; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            DFS(depth + 1, i, sum + number[i]);
            visit[i] = false;
        }
    }
}
