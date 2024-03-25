/*
 * 24/03/25
 * 
 * 프로그래머스 - 가장 많이 받은 선물
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/258712
 */

// 내 풀이
import java.util.*;

class Solution_Me {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        
        int[] giftScore = new int[friends.length];
        int[][] giftMap = new int[friends.length][friends.length];
        
        for (String gift: gifts) {
            String[] temp = gift.split(" ");
            int provider = map.get(temp[0]);
            int target = map.get(temp[1]);
            
            giftScore[provider] += 1;
            giftScore[target] -= 1;
            giftMap[provider][target] += 1;
        }
        
        // i 기준으로 받는 선물 계산
        for (int i = 0; i < friends.length; i++){
            int iCount = 0;
            
            for (int j = 0; j < friends.length; j++) {
                
                if (i == j) continue;  // 본인 일 경우 pass
                
                if (giftMap[i][j] > giftMap[j][i]) {  // i가 j 보다 선물을 더 많이 준 경우
                    iCount += 1;
                } else if (giftMap[i][j] == giftMap[j][i] &&  // 선물 횟수가 같고 선물 지수가 높을 경우
                           giftScore[i] > giftScore[j]) {
                    iCount += 1;
                }
            }
            
            answer = Math.max(iCount, answer);
        }
        
        return answer;
    }
}
