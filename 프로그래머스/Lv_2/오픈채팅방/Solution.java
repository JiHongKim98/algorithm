/*
 * 프로그래머스 - 오픈채팅방
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 */
package Lv_2.오픈채팅방;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();

        int count = record.length;
        for (String r : record) {
            String[] split = r.split(" ");

            if (split[0].equals("Enter")) {
                map.put(split[1], split[2]);
            } else if (split[0].equals("Change")) {
                map.put(split[1], split[2]);
                count--;
            }
        }

        String[] answer = new String[count];
        int idx = 0;
        for (String r : record) {
            String[] split = r.split(" ");

            if (split[0].equals("Enter")) {
                answer[idx++] = map.get(split[1]) + "님이 들어왔습니다.";
            } else if (split[0].equals("Leave")) {
                answer[idx++] = map.get(split[1]) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
