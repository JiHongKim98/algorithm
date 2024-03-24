/*
 * 24/03/24
 * 
 * 프로그래머스 - 로또의 최고 순위와 최저 순위
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/77484
 */

// 내 풀이
import java.util.*;

class Solution_Me {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        for (int lotto: lottos) {
            
            if (lotto == 0) {
                answer[0] += 1;
                continue;
            }
            
            for (int win_num: win_nums) {
                if (lotto == win_num) {
                    answer[0] += 1;
                    answer[1] += 1;
                }
            }
        }
        
        answer[0] = rank[answer[0]];
        answer[1] = rank[answer[1]];
        
        return answer;
    }
}

// 다른 사람 풀이 (성능 개선 버전)
// import java.util.HashMap;
// import java.util.Map;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int zeroCount = 0;

        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
                continue;
            }
            map.put(lotto, true);
        }


        int sameCount = 0;
        for(int winNum : win_nums) {
            if(map.containsKey(winNum)) sameCount++;
        }

        int maxRank = 7 - (sameCount + zeroCount);
        int minRank = 7 - sameCount;
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;

        return new int[] {maxRank, minRank};
    }
}
