/*
 * 프로그래머스 - 순위
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/49191
 */
package Lv_3.순위;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] map = new int[n + 1][n + 1];
        for (int[] result : results) {
            map[result[0]][result[1]] = 1;  // 승
            map[result[1]][result[0]] = -1;  // 패
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (map[i][j] == 1 && map[j][k] == 1) {
                        map[i][k] = 1;
                        map[k][i] = -1;
                    }

                    if (map[i][j] == -1 && map[j][k] == -1) {
                        map[i][k] = -1;
                        map[k][i] = 1;
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            int count = 0;
            for (int j = 1; j < n + 1; j++) {
                if (map[i][j] != 0) count++;
            }

            if (count == n - 1) answer++;  // 본인 빼고 전부 기록이 있는 경우
        }

        return answer;
    }
}
