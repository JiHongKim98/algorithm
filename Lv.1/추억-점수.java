/*
 * 24/03/18
 * 
 * 프로그래머스 - 추억 점수 문제
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 */

import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        // <이름, 그리움 점수>
        Map<String, Integer> yearningMap = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            yearningMap.put(name[i], yearning[i]);  // init map
        }
        
        for (int k = 0; k < photo.length; k++) {
            int score = 0;
            
            for (int j = 0; j < photo[k].length; j++) {
                
                // 그리움 점수가 있는 사람인가?
                if (yearningMap.containsKey(photo[k][j])) {
                    // 있으면 그리움 점수 SUM
                    score += yearningMap.get(photo[k][j]);
                }
            }
            
            answer[k] = score;
        }
        return answer;
    }
}
