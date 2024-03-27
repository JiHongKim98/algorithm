/*
 * 24/03/27
 * 
 * 프로그래머스 - [1차] 다트 게임
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/17682
 */

// 내 풀이
class Solution_Me {
    public int solution(String dartResult) {
        int answer = 0;
        
        String[] darts = dartResult.split("");
        int[] score = new int[3];
        int scoreIdx = -1;
        
        for (int i = 0; i < darts.length; i++) {
            
            if (darts[i].matches("[0-9]")) {
                scoreIdx += 1;
                
                score[scoreIdx] = Integer.parseInt(darts[i]);
                
                if (darts[i + 1].matches("[0-9]")) {
                    score[scoreIdx] *= 10;
                    score[scoreIdx] += Integer.parseInt(darts[i + 1]);
                    i++;
                }
            }
            
            
            switch(darts[i]) {
                case "D":
                    score[scoreIdx] = (int) Math.pow(score[scoreIdx], 2);
                    break;
                case "T":
                    score[scoreIdx] = (int) Math.pow(score[scoreIdx], 3);
                    break;
                case "*":
                    score[scoreIdx] *= 2;
                    if (scoreIdx != 0) score[scoreIdx - 1] *= 2;
                    break;
                case "#":
                    score[scoreIdx] *= -1;
                    break;
            }
        }
        
        for (int temp: score) {
            System.out.println(temp);
            answer += temp;
        }
        
        return answer;
    }
}
