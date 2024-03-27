/*
 * 24/03/27
 * 
 * 프로그래머스 - 옹알이 (2)
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/133499
 */

// 내 풀이
class Solution_Me {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String temp: babbling) {
            if(temp.contains("ayaaya") || 
               temp.contains("yeye") || 
               temp.contains("woowoo") || 
               temp.contains("mama")) {
                continue;
            }
            
            temp = temp.replace("aya", " ");
            temp = temp.replace("ye", " ");
            temp = temp.replace("woo", " ");
            temp = temp.replace("ma", " ");
            temp = temp.replace(" ", "");
            
            if (temp.equals("")) answer += 1;
        }
        
        return answer;
    }
}
