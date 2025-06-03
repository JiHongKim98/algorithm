/*
 * 프로그래머스 - 지게차와 크레인
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/388353
 */
package Lv_2.지게차와_크레인;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};

    public int solution(String[] storage, String[] requests) {
        int row = storage.length;
        int col = storage[0].length();

        char[][] map = new char[row][col];
        for (int i = 0; i < row; i++) map[i] = storage[i].toCharArray();

        int count = 0;
        for (String request : requests) {
            char target = request.charAt(0);

            if (request.length() > 1) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (map[i][j] == target) {
                            map[i][j] = '-';
                            count++;
                        }
                    }
                }
            } else {
                boolean[][] visit = new boolean[row][col];
                Queue<int[]> queue = new LinkedList<>();

                for (int i = 0; i < row; i++) {
                    queue.add(new int[]{i, 0});
                    queue.add(new int[]{i, col - 1});
                }

                for (int i = 0; i < col; i++) {
                    queue.add(new int[]{0, i});
                    queue.add(new int[]{row - 1, i});
                }

                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();

                    int x = poll[0];
                    int y = poll[1];

                    if (visit[x][y]) continue;
                    else visit[x][y] = true;

                    if (map[x][y] == target) {
                        map[x][y] = '-';
                        count++;
                    } else if (map[x][y] == '-') {
                        for (int i = 0; i < 4; i++) {
                            int nextX = x + dx[i];
                            int nextY = y + dy[i];

                            if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col) {
                                queue.add(new int[]{nextX, nextY});
                            }
                        }
                    }
                }
            }
        }

        return row * col - count;
    }
}
