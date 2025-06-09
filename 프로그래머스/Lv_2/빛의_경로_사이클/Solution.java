/*
 * 프로그래머스 - 빛의_경로_사이클
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/86052
 */
package Lv_2.빛의_경로_사이클;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};

    public int[] solution(String[] grid) {
        char[][] map = new char[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; i++) map[i] = grid[i].toCharArray();

        List<Integer> answerMap = new ArrayList<>();
        boolean[][][] visit = new boolean[grid.length][grid[0].length()][4];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                for (int d = 0; d < 4; d++) {
                    if (!visit[i][j][d]) {
                        int row = i;
                        int col = j;
                        int dir = d;

                        int count = 0;

                        while (!visit[row][col][dir]) {
                            count++;

                            visit[row][col][dir] = true;

                            switch (map[row][col]) {
                                case 'L' -> dir = (dir + 3) % 4;
                                case 'R' -> dir = (dir + 1) % 4;
                            }

                            row = (grid.length + row + dx[dir]) % grid.length;
                            col = (grid[0].length() + col + dy[dir]) % grid[0].length();
                        }

                        answerMap.add(count);
                    }
                }
            }
        }

        return answerMap.stream().mapToInt(i -> i).sorted().toArray();
    }
}
