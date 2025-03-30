/*
 * 프로그래머스 - 표 병합
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/150366
 */
package Lv_3.표_병합;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private String[] map = new String[51 * 51];
    private int[] parentMap = new int[51 * 51];
    private List<String> printer = new ArrayList<>();

    public String[] solution(String[] commands) {
        for (int i = 0; i < 51 * 51; i++) {
            parentMap[i] = i;
            map[i] = "EMPTY";
        }

        for (String command : commands) {
            String[] split = command.split(" ");

            switch (split[0]) {
                case "UPDATE":
                    if (split.length == 4) {
                        update(Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3]);
                    } else {
                        updateAll(split[1], split[2]);
                    }
                    break;

                case "MERGE":
                    merge(
                            Integer.parseInt(split[1]), Integer.parseInt(split[2]),
                            Integer.parseInt(split[3]), Integer.parseInt(split[4])
                    );
                    break;

                case "UNMERGE":
                    unmerge(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                    break;

                case "PRINT":
                    print(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                    break;
            }
        }

        return printer.toArray(new String[0]);
    }

    private void update(int x, int y, String value) {
        int root = find(convertIdx(x, y));
        map[root] = value;
    }

    private void updateAll(String before, String after) {
        for (int i = 0; i < 51 * 51; i++) {
            if (map[i].equals(before)) map[i] = after;
        }
    }

    private void merge(int x1, int y1, int x2, int y2) {
        int idx1 = convertIdx(x1, y1);
        int idx2 = convertIdx(x2, y2);

        int root1 = find(idx1);
        int root2 = find(idx2);

        if (root1 == root2) return;

        String value = map[root1].equals("EMPTY") ? map[root2] : map[root1];
        union(root1, root2);
        int newRoot = find(root1);

        map[newRoot] = value;
    }

    private void unmerge(int x, int y) {
        int idx = convertIdx(x, y);
        int root = find(idx);
        String value = map[root];

        List<Integer> group = new ArrayList<>();
        for (int i = 0; i < 51 * 51; i++) {
            if (find(i) == root) group.add(i);
        }

        for (int i : group) {
            parentMap[i] = i;
            map[i] = "EMPTY";
        }

        map[idx] = value;
    }

    private void print(int x, int y) {
        int root = find(convertIdx(x, y));
        printer.add(map[root]);
    }

    private int convertIdx(int x, int y) {
        return x * 51 + y;
    }

    private int find(int idx) {
        if (parentMap[idx] == idx) return idx;
        return parentMap[idx] = find(parentMap[idx]);
    }

    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        parentMap[pb] = pa;
    }
}
