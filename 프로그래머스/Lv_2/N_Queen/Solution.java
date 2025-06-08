/*
 * 프로그래머스 - N Queen
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12952
 */
package Lv_2.N_Queen;

class Solution {

    private int answer = 0;
    private int[] map;

    public int solution(int n) {
        map = new int[n];

        DFS(0);

        return answer;
    }

    private void DFS(int curr) {
        if (curr == map.length) {
            answer++;
        } else {
            for (int i = 0; i < map.length; i++) {
                map[curr] = i;

                if (check(curr)) DFS(curr + 1);
            }
        }
    }

    private boolean check(int col) {
        for (int i = 0; i < col; i++) {
            if (
                    map[i] == map[col] ||
                            Math.abs(i - col) == Math.abs(map[i] - map[col])
            ) return false;
        }
        return true;
    }
}
