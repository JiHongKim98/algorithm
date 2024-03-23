/*
 * 24/03/23
 * 
 * 프로그래머스 - 체육복
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */

// 내 풀이
import java.util.*;

class Solution_Me {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        // 도난 안당한 사람수
        answer += n - lost.length;
        
        // 여벌이 있지만 도난 당한 사람
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer += 1;
                    lost[i] = -1;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        
        // 빌릴 수 있는 사람수
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer += 1;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        
        return answer;
    }
}

// 다른 사람 풀이
class Solution_Other {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) 
            people[l-1]--;
        for (int r : reserve) 
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }
}
