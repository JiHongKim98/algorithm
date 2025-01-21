/*
 * 프로그래머스 - 미로 탈출
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
 */
package Lv_2.미로_탈출;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static char[][] miro;

    public int solution(String[] maps) {
        miro = new char[maps.length][maps[0].length()];

        int start[] = new int[2];
        int laver[] = new int[2];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (c == 'L') {
                    laver[0] = i;
                    laver[1] = j;
                }

                miro[i][j] = c;
            }
        }

        int leverMoveCount = bfs(start, 'L');
        if (leverMoveCount < 0) return -1;

        int exitMoveCount = bfs(laver, 'E');
        if (exitMoveCount < 0) return -1;

        return leverMoveCount + exitMoveCount;
    }

    private int bfs(int[] startIdx, char target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startIdx[0], startIdx[1], 0});

        boolean[][] visit = new boolean[miro.length][miro[0].length];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int x = poll[0];
            int y = poll[1];
            int idx = poll[2];

            if (miro[x][y] == target) {
                return idx;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (
                        (newX >= 0 && newX < miro.length) &&
                                (newY >= 0 && newY < miro[0].length) &&
                                !visit[newX][newY] &&
                                miro[newX][newY] != 'X'
                ) {
                    visit[newX][newY] = true;
                    queue.add(new int[]{newX, newY, idx + 1});
                }
            }
        }

        return -1;
    }
}
