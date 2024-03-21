/*
 * 24/03/21
 * 
 * 프로그래머스 - 키패드 누르기
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 */

// 내 풀이
class Solution_Me {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int nowLeft = 10;  // 시작 위치
        int nowRight = 12;  // 시작 위치
        
        for (int num: numbers) {
            if (num == 0) {
                num = 11;  // 0 을 11로 치환
            }
            
            if (num % 3 == 1) {
                answer += "L";
                nowLeft = num;
            } else if (num % 3 == 0) {
                answer += "R";
                nowRight = num;
            } else {
                
                if (dist(nowLeft, num) < dist(nowRight, num)) {
                    answer += "L";
                    nowLeft = num;
                } else if (dist(nowLeft, num) > dist(nowRight, num)) {
                    answer += "R";
                    nowRight = num;
                } else {
                    
                    if (hand.equals("left")) {
                        answer += "L";
                        nowLeft = num;
                    } else {
                        answer += "R";
                        nowRight = num;
                    }
                    
                }
            }
        }
        
        return answer;
    }
    
    private int dist(int nowNum, int pushNum) {
        int height = Math.abs(nowNum - pushNum) % 3;  // 세로 이동 거리
        int weight = Math.abs(nowNum - pushNum) / 3;  // 가로 이동 거리
        return height + weight;
    }
}
