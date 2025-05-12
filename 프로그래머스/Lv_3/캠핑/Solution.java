/*
 * 프로그래머스 - 캠핑
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1833
 */
package Lv_3.캠핑;

import java.util.*;

class Solution {
    public int solution(int n, int[][] data) {
        List<Integer> mapX = new ArrayList<>();
        List<Integer> mapY = new ArrayList<>();

        for (int[] p : data) {
            mapX.add(p[0]);
            mapY.add(p[1]);
        }

        List<Integer> idxX = new ArrayList<>(new HashSet<>(mapX));
        List<Integer> idxY = new ArrayList<>(new HashSet<>(mapY));
        Collections.sort(idxX);
        Collections.sort(idxY);

        int[][] dp = new int[n][n];
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            int x = idxX.indexOf(data[i][0]);
            int y = idxY.indexOf(data[i][1]);

            map[i][0] = x;
            map[i][1] = y;
            dp[x][y] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) dp[i][j] += dp[i - 1][j];  // 같은 행
                if (j - 1 >= 0) dp[i][j] += dp[i][j - 1];  // 같은 열
                if (i - 1 >= 0 & j - 1 >= 0) dp[i][j] -= dp[i - 1][j - 1];  // 대각선
            }
        }

        Arrays.sort(data, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = Math.min(map[i][0], map[j][0]);
                int x2 = Math.max(map[i][0], map[j][0]);

                int y1 = Math.min(map[i][1], map[j][1]);
                int y2 = Math.max(map[i][1], map[j][1]);

                if (x1 == x2 || y1 == y2) continue;

                if (dp[x1][y1] - dp[x2 - 1][y1] - dp[x1][y2 - 1] + dp[x2 - 1][y2 - 1] == 0) answer++;
            }
        }

        return answer;
    }
}
