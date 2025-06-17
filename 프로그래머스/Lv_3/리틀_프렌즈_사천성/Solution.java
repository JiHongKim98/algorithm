/*
 * 프로그래머스 - 리틀 프렌즈 사천성
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1836
 */
package Lv_3.리틀_프렌즈_사천성;

import java.util.*;

class Solution {
    class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        Map<Character, List<Pos>> tileMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();

            for (int j = 0; j < n; j++) {
                char c = map[i][j];

                if ('A' <= c && c <= 'Z') {
                    tileMap.computeIfAbsent(c, k -> new ArrayList<>()).add(new Pos(i, j));
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        int tileCount = tileMap.size();

        for (int i = 0; i < tileCount; i++) {
            boolean erased = false;
            List<Character> keys = new ArrayList<>(tileMap.keySet());
            Collections.sort(keys);

            for (char c : keys) {
                List<Pos> positions = tileMap.get(c);
                Pos p1 = positions.get(0);
                Pos p2 = positions.get(1);

                if (canRemove(map, p1, p2)) {
                    map[p1.x][p1.y] = '.';
                    map[p2.x][p2.y] = '.';
                    tileMap.remove(c);
                    answer.append(c);
                    erased = true;
                    break;
                }
            }

            if (!erased) return "IMPOSSIBLE";
        }
        return answer.toString();
    }

    private boolean canRemove(char[][] map, Pos p1, Pos p2) {
        return (isClear(map, p1, p2))
                || (isClear(map, p1, new Pos(p1.x, p2.y)) && isClear(map, new Pos(p1.x, p2.y), p2)
                && (map[p1.x][p2.y] == '.' || (p1.x == p2.x && p2.y == p1.y)))
                || (isClear(map, p1, new Pos(p2.x, p1.y)) && isClear(map, new Pos(p2.x, p1.y), p2)
                && (map[p2.x][p1.y] == '.' || (p2.x == p1.x && p1.y == p2.y)));
    }

    private boolean isClear(char[][] map, Pos p1, Pos p2) {
        if (p1.x == p2.x) {
            for (int y = Math.min(p1.y, p2.y) + 1; y < Math.max(p1.y, p2.y); y++) {
                if (map[p1.x][y] != '.') return false;
            }
            return true;
        } else if (p1.y == p2.y) {
            for (int x = Math.min(p1.x, p2.x) + 1; x < Math.max(p1.x, p2.x); x++) {
                if (map[x][p1.y] != '.') return false;
            }
            return true;
        }
        return false;
    }
}
