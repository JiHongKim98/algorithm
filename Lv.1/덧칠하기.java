/*
 * 24/03/28
 * 
 * 프로그래머스 - 덧칠하기
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/161989
 */

// 내 풀이
class Solution_Me {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int coverage = -1;  // 커버할 수 있는 벽의 수
        
        for (int temp: section) {
            if (temp <= coverage) continue;
            
            answer += 1;
            
            coverage = temp + m - 1;
        }
        
        return answer;
    }
}
