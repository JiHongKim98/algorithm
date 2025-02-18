/*
 * 프로그래머스 - 기둥과 보 설치
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/60061
 */
package Lv_3.기둥과_보_설치;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int n;
    private boolean[][][] map;

    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;

        map = new boolean[n + 1][n + 1][2];  // 0 - 기둥, 1 - 보

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];

            if (frame[3] == 1) {
                if (type == 0) {
                    if (canAppendPillar(x, y)) map[x][y][0] = true;
                } else {
                    if (canAppendBeam(x, y)) map[x][y][1] = true;
                }
            } else {
                if (type == 0) map[x][y][0] = false;
                else map[x][y][1] = false;

                if (!valid()) {
                    if (type == 0) map[x][y][0] = true;
                    else map[x][y][1] = true;
                }
            }
        }

        List<int[]> result = new ArrayList<>();
        for (int x = 0; x < n + 1; x++) {
            for (int y = 0; y < n + 1; y++) {
                if (map[x][y][0]) result.add(new int[]{x, y, 0});
                if (map[x][y][1]) result.add(new int[]{x, y, 1});
            }
        }

        result.sort(((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return o1[2] - o2[2];
                }
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));

        return result.toArray(new int[result.size()][]);
    }

    private boolean canAppendPillar(int x, int y) {
        return (y == 0) ||
                (y > 0 && map[x][y - 1][0]) ||
                (map[x][y][1]) ||
                (x > 0 && map[x - 1][y][1]);
    }

    private boolean canAppendBeam(int x, int y) {
        return (y > 0 && map[x][y - 1][0]) ||
                (y > 0 && map[x + 1][y - 1][0]) ||
                (x > 0 && map[x - 1][y][1] && map[x + 1][y][1]);
    }

    private boolean valid() {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (map[x][y][0] && !canAppendPillar(x, y)) return false;
                if (map[x][y][1] && !canAppendBeam(x, y)) return false;
            }
        }
        return true;
    }
}
