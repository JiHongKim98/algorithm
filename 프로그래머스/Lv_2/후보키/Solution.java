/*
 * 프로그래머스 - 후보키
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42890
 */
package Lv_2.후보키;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    private String[][] relation;
    private List<Set<Integer>> keyMap = new ArrayList<>();
    private List<List<Integer>> combMap = new ArrayList<>();

    public int solution(String[][] relation) {
        this.relation = relation;

        for (int i = 1; i <= relation[0].length; i++) DFS(new ArrayList<>(), 0, i);

        int answer = 0;
        for (List<Integer> map : combMap) {
            if (isMinimal(map) && isUnique(map)) {
                keyMap.add(new HashSet<>(map));
                answer++;
            }
        }

        return answer;
    }

    private void DFS(List<Integer> path, int start, int end) {
        if (path.size() == end) {
            combMap.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            path.add(i);

            DFS(path, i + 1, end);

            path.remove(path.size() - 1);
        }
    }

    private boolean isMinimal(List<Integer> currMap) {
        Set<Integer> currSet = new HashSet<>(currMap);

        for (Set<Integer> key : keyMap) {
            if (currSet.containsAll(key)) return false;
        }

        return true;
    }

    private boolean isUnique(List<Integer> currMap) {
        Set<String> uniqueMap = new HashSet<>();

        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();

            for (int idx : currMap) sb.append(row[idx]).append("|");

            if (!uniqueMap.add(sb.toString())) return false;
        }

        return true;
    }
}
