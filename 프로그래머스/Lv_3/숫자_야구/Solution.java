/*
 * 프로그래머스 - 숫자 야구
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/451808
 */
package Lv_3.숫자_야구;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Solution {

    private List<Integer> map;

    public int solution(int n, Function<Integer, String> submit) {
        map = new ArrayList<>();
        DFS(0, new boolean[10], 1);

        while (map.size() != 1) {
            int curr = map.get(0);
            String result = submit.apply(curr);

            if (result.equals("4S 0B")) return curr;

            map = filter(map, curr, result);
        }

        return map.get(0);
    }

    private void DFS(int curr, boolean[] visit, int depth) {
        if (depth > 4) {
            map.add(curr);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            DFS(curr * 10 + i, visit, depth + 1);
            visit[i] = false;
        }
    }

    private List<Integer> filter(List<Integer> target, int num, String result) {
        List<Integer> newMap = new ArrayList<>();

        String strNum = String.valueOf(num);

        String[] split = result.split("");
        int s = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[3]);

        for (int t : target) {
            int currS = 0;
            int currB = 0;
            String strT = String.valueOf(t);

            loop:
            for (int i = 0; i < 4; i++) {
                char curr = strT.charAt(i);

                if (strNum.charAt(i) == curr) currS++;
                else if (strNum.indexOf(curr) != -1) currB++;

                if (currS > s || currB > b) break loop;
            }

            if (s == currS && b == currB) newMap.add(t);
        }

        return newMap;
    }
}
