/*
 * 프로그래머스 - [3차] 자동완성
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17685
 */
package Lv_4.삼차_자동완성;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] words) {
        Token token = new Token();
        for (String word : words) {
            token.append(word);
        }

        int answer = 0;
        for (String word : words) {
            answer += token.searchDepth(word);
        }

        return answer;
    }

    class Token {
        int childCount = 0;

        Map<Character, Token> map = new HashMap<>();

        void append(String word) {
            Token currToken = this;

            for (char c : word.toCharArray()) {
                currToken.map.putIfAbsent(c, new Token());

                currToken = currToken.map.get(c);
                currToken.childCount++;
            }
        }

        int searchDepth(String word) {
            Token currToken = this;

            int depth = 0;

            for (char c : word.toCharArray()) {
                depth++;
                currToken = currToken.map.get(c);

                if (currToken.childCount == 1) return depth;
            }
            return depth;
        }
    }
}
