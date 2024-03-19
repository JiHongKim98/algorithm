/*
 * 24/03/20
 * 
 * 프로그래머스 - 둘만의 암호
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/155652
 */

// 내 풀이
class Solution_Me {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            char nowChar = s.charAt(i);
            
            for (int count = 0; count < index; count++) {
                nowChar += 1;
                
                // 'z' 를 넘어가면 'a' 로 변경
                if (nowChar > 'z') nowChar -= 26;
                
                // skip에 포함된 단어면 count 하지 않음
                if (skip.contains(String.valueOf(nowChar))) count--;
            }
            
            answer += nowChar;
        }
        
        return answer;
    }
}

// 다른 사람 풀이
class Solution_Other {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }
}
