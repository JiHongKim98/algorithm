/*
 * 24/03/24
 * 
 * 프로그래머스 - 대충 만든 자판
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
 */

// 내 풀이
import java.util.*;

class Solution_Me {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<String, Integer> minKey = new HashMap<>();
        for (String key: keymap) {
            String[] split = key.split("");
            
            for (int i = 0; i < split.length; i++) {
                int num = minKey.getOrDefault(split[i], i + 1);
                minKey.put(split[i], Math.min(num, i+1));
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            String[] split = targets[i].split("");
            
            for (int j = 0; j < split.length; j++) {
                if (minKey.containsKey(split[j])) {
                    answer[i] += minKey.get(split[j]);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
