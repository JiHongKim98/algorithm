/*
 * 프로그래머스 - 고고학 최고의 발견
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131702
 */
package Lv_3.고고학_최고의_발견;

class Solution {

    private int[] dx = {0, 0, 0, -1, 1};
    private int[] dy = {0, -1, 1, 0, 0};

    private int[][] clockHands;
    private int answer = Integer.MAX_VALUE;

    public int solution(int[][] clockHands) {
        this.clockHands = clockHands;

        DFS(new int[clockHands.length], 0);

        return answer;
    }

    private void DFS(int[] firstClickMap, int idx) {
        if (idx == clockHands.length) {
            int[][] clone = new int[clockHands.length][clockHands[0].length];
            for (int i = 0; i < clockHands.length; i++) clone[i] = clockHands[i].clone();

            int count = 0;
            for (int i = 0; i < clockHands.length; i++) {
                for (int j = 0; j < firstClickMap[i]; j++) {
                    click(clone, 0, i);
                    count++;
                }
            }

            for (int i = 1; i < clockHands.length; i++) {
                for (int j = 0; j < clockHands[0].length; j++) {
                    int requireClickCount = (4 - clone[i - 1][j]) % 4;

                    for (int k = 0; k < requireClickCount; k++) {
                        click(clone, i, j);
                        count++;
                    }
                }
            }

            for (int i = 0; i < clockHands.length; i++) {
                for (int j = 0; j < clockHands[0].length; j++) {
                    if (clone[i][j] != 0) return;
                }
            }
            answer = Math.min(answer, count);
        } else {
            for (int i = 0; i < 4; i++) {
                firstClickMap[idx] = i;
                DFS(firstClickMap, idx + 1);
            }
        }
    }

    private void click(int[][] clone, int x, int y) {
        for (int d = 0; d < 5; d++) {
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if (nextX < 0 || nextX >= clockHands.length || nextY < 0 || nextY >= clockHands[0].length) continue;

            clone[nextX][nextY] = (clone[nextX][nextY] + 1) % 4;
        }
    }
}
