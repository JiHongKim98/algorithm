/*
 * 프로그래머스 - 방문 길이
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/49994
 */
package Lv_2.방문_길이;

class Solution {

    private static final int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int solution(String dirs) {
        int answer = 0;

        boolean[][][] visit = new boolean[11][11][4];

        int x = 5, y = 5;

        int[] dirIdx = new int[128];
        dirIdx['U'] = 0;
        dirIdx['D'] = 1;
        dirIdx['L'] = 2;
        dirIdx['R'] = 3;

        for (char curr : dirs.toCharArray()) {
            int d = dirIdx[curr];

            int nx = x + move[d][0];
            int ny = y + move[d][1];

            if (nx >= 0 && nx <= 10 && ny >= 0 && ny <= 10) {
                if (!visit[x][y][d]) {
                    answer++;
                    visit[x][y][d] = true;
                    visit[nx][ny][(d ^ 1)] = true; // 반대 방향 방문
                }

                x = nx;
                y = ny;
            }
        }
        return answer;
    }
}
