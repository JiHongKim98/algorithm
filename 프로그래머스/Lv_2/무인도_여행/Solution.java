/*
 * 프로그래머스 - 무인도 여행
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 */
package Lv_2.무인도_여행;

import java.util.*;

class Solution {

    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};

    private String[] maps;
    private boolean[][] visit;
    private List<Integer> answerMap;

    public int[] solution(String[] maps) {
        this.maps = maps;
        visit = new boolean[maps.length][maps[0].length()];
        answerMap = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'X' || visit[i][j]) continue;
                visit[i][j] = true;
                bfs(i, j);
            }
        }

        if (answerMap.size() == 0) return new int[]{-1};

        Collections.sort(answerMap);
        int[] answer = new int[answerMap.size()];
        for (int i = 0; i < answerMap.size(); i++) answer[i] = answerMap.get(i);
        return answer;
    }

    private void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int sum = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            sum += Integer.parseInt(String.valueOf(maps[poll[0]].charAt(poll[1])));

            for (int i = 0; i < 4; i++) {
                int nextX = poll[0] + dx[i];
                int nextY = poll[1] + dy[i];

                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length()) continue;

                if (!visit[nextX][nextY] && maps[nextX].charAt(nextY) != 'X') {
                    queue.add(new int[]{nextX, nextY});
                    visit[nextX][nextY] = true;
                }
            }
        }

        answerMap.add(sum);
    }
}
