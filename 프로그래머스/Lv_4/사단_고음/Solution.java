/*
 * 프로그래머스 - 4단 고음
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1831
 */
package Lv_4.사단_고음;

class Solution {
    public int solution(int n) {
        return DFS(n - 2, 2);
    }

    private int DFS(int remains, int plus) {
        if (remains == 3 && plus == 2) return 1;

        if (
                (remains < 3) || (remains == 3 && remains == plus) ||
                        (remains < Math.pow(3, plus / 2))  // '+' 2개당 3개 이상 남아 있어야함
        ) return 0;

        int count = DFS(remains - 1, plus + 1);

        if (plus > 1 && remains % 3 == 0) count += DFS(remains / 3, plus - 2);

        return count;
    }
}
