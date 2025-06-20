/*
 * 프로그래머스 - 단체사진 찍기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1835
 */
package Lv_2.단체사진_찍기;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int answer = 0;
    private char[] map = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private List<Ruleset> rulesetMap = new ArrayList<>();

    public int solution(int n, String[] data) {
        for (String d : data) {
            String numStr = String.valueOf(d.charAt(4));
            rulesetMap.add(new Ruleset(d.charAt(0), d.charAt(2), Integer.parseInt(numStr), d.charAt(3)));
        }

        DFS(new ArrayList<Character>(), new boolean[8]);

        return answer;
    }

    private void DFS(List<Character> curr, boolean[] visit) {
        if (curr.size() == 8) {
            for (Ruleset ruleset : rulesetMap) {
                if (!ruleset.check(curr)) return;
            }
            answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visit[i]) {
                visit[i] = true;

                curr.add(map[i]);
                DFS(curr, visit);
                curr.remove(curr.size() - 1);

                visit[i] = false;
            }
        }
    }

    class Ruleset {
        char a;
        char b;
        int len;
        char expression;

        public Ruleset(char a, char b, int len, char expression) {
            this.a = a;
            this.b = b;
            this.len = len;
            this.expression = expression;
        }

        public boolean check(List<Character> checkMap) {
            int currLen = Math.abs(checkMap.indexOf(a) - checkMap.indexOf(b)) - 1;

            if (expression == '=') return currLen == len;
            else if (expression == '>') return currLen > len;
            else return currLen < len;
        }
    }
}
