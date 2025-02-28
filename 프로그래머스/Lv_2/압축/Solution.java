/*
 * 프로그래머스 - [3차] 압축
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17684
 */
package Lv_2.압축;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answerMap = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        char startA = 'A';
        for (int i = 1; i <= 26; i++) {
            map.put(String.valueOf(startA), i);
            startA++;
        }

        int idx = 0;
        int mapSeq = 27;

        while (idx < msg.length()) {
            int currIdx = idx;
            String currMsg = "";

            while (currIdx < msg.length() && map.containsKey(msg.substring(idx, currIdx + 1))) {
                currMsg = msg.substring(idx, currIdx + 1);
                currIdx++;
            }

            answerMap.add(map.get(currMsg));

            if (currIdx < msg.length()) {
                map.put(msg.substring(idx, currIdx + 1), mapSeq++);
            }

            idx = currIdx;
        }

        int[] answer = new int[answerMap.size()];
        for (int i = 0; i < answerMap.size(); i++) {
            answer[i] = answerMap.get(i);
        }
        return answer;
    }
}
