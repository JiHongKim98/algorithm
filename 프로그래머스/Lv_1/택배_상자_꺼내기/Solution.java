/*
 * 프로그래머스 - 택배 상자 꺼내기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/389478
 */
package Lv_1.택배_상자_꺼내기;

class Solution {
    public int solution(int n, int w, int num) {
        int row = (num - 1) / w;
        int col = (num - 1) % w;
        if (row % 2 != 0) col = (w - 1) - col;

        int answer = 0;
        int maxRow = (n + w - 1) / w;
        for (int i = row; i < maxRow; i++) {
            int idx;

            if (i % 2 == 0) idx = col + i * w;
            else idx = (w - 1 - col) + i * w;

            if (idx < n) answer++;
        }

        return answer;
    }
}
