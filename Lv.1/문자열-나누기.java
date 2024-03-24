/*
 * 24/03/24
 * 
 * 프로그래머스 - 문자열 나누기
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/140108
 */

// 내 풀이
class Solution_Me {
    public int solution(String s) {
        int answer = 0;
        
        char charL = s.charAt(0);
        
        int correct = 0;
        int incorrect = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == charL) {
                correct += 1;
            } else {
                incorrect += 1;
            }
            
            if (correct == incorrect) {
                answer += 1;
                
                if (i < s.length() - 1) {
                    charL = s.charAt(i + 1);
                }
                
            } else if (i == s.length() - 1) {
                answer += 1;
            }
            
        }
        
        return answer;
    }
}

// 다른 사람 풀이
class Solution {

    public int solution(String s) {
        char prev = '1';
        int same = 0, different = 0, answer = 0;
        for (char c : s.toCharArray()) {
            if (prev == '1') {
                prev = c;
                same++;
                answer++;
            } else if (prev == c) {
                same++;
            } else {
                different++;
            }

            if (same == different) {
                prev = '1';
                same = 0; different = 0;
            }
        }

        return answer;
    }
}
