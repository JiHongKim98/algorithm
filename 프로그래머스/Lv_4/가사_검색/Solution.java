/*
 * 프로그래머스 - 가사 검색
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/60060
 */

package Lv_4.가사_검색;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        Token forward = new Token();
        Token backward = new Token();
        for (String word : words) {
            forward.append(word, 0);
            backward.append(reverse(word), 0);
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (queries[i].charAt(0) == '?') answer[i] = backward.countByWords(reverse(queries[i]), 0);
            else answer[i] = forward.countByWords(queries[i], 0);
        }

        return answer;
    }

    private String reverse(String word) {
        return new StringBuffer(word).reverse().toString();
    }

    class Token {
        private Map<Character, Token> node = new HashMap<>();

        private Map<Integer, Integer> matchCountMap = new HashMap<>();

        void append(String word, int depth) {
            int remainLength = word.length() - depth;
            matchCountMap.put(remainLength, matchCountMap.getOrDefault(remainLength, 0) + 1);

            if (remainLength > 0) {
                char currToken = word.charAt(depth);

                Token childNode = node.getOrDefault(currToken, new Token());
                node.put(currToken, childNode);

                childNode.append(word, depth + 1);
            }
        }

        int countByWords(String word, int depth) {
            char searchChar = word.charAt(depth);
            int searchLength = word.length() - depth;

            if (searchChar == '?') return matchCountMap.getOrDefault(searchLength, 0);
            else if (node.containsKey(searchChar)) return node.get(searchChar).countByWords(word, depth + 1);
            else return 0;
        }
    }
}
