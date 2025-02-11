/*
 * 프로그래머스 - 기능개발
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
package Lv_2.기능개발;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] map = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];

            if (remain > 0) {
                map[i] = remain / speeds[i];
                if (remain % speeds[i] != 0) map[i] += 1;
            } else {
                map[i] = 0;
            }
        }

        int count = 1;
        int currMax = map[0];
        List<Integer> answerMap = new ArrayList<>();

        for (int i = 1; i < map.length; i++) {
            if (map[i] <= currMax) {
                count++;
            } else {
                answerMap.add(count);
                count = 1;
                currMax = map[i];
            }
        }
        answerMap.add(count);

        int[] answer = new int[answerMap.size()];
        for (int i = 0; i < answerMap.size(); i++) {
            answer[i] = answerMap.get(i);
        }

        return answer;
    }
}
