/*
 * 프로그래머스 - 비밀 코드 해독
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/388352
 */
package Lv_2.비밀_코드_해독;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int[][] q;
    private int[] ans;
    private int n;

    private int answer = 0;

    public int solution(int n, int[][] q, int[] ans) {
        this.q = q;
        this.ans = ans;
        this.n = n;

        DFS(1, new ArrayList<>());

        return answer;
    }

    private void DFS(int curr, List<Integer> comb) {
        if (comb.size() == 5) {
            check(comb);
            return;
        }

        for (int i = curr; i <= n; i++) {
            comb.add(i);

            DFS(i + 1, comb);

            comb.remove(comb.size() - 1);
        }
    }

    private void check(List<Integer> comb) {
        for (int i = 0; i < q.length; i++) {
            int count = 0;

            for (int num : q[i]) {
                if (comb.contains(num)) count++;
            }

            if (count != ans[i]) return;
        }

        answer++;
    }
}
