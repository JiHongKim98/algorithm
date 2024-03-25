/*
 * 24/03/25
 * 
 * 프로그래머스 - 완주하지 못한 선수
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */

// 내 풀이
import java.util.*;

class Solution_Me {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}
