/*
 * 24/03/23
 * 
 * 프로그래머스 - 이웃한 칸
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/250125
 */

// 내 풀이
class Solution_Me {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String baseColor = board[h][w];
        int maxLength = board.length;
        
        int[][] checkList = { {h-1, w}, {h+1, w}, {h, w-1}, {h, w+1} };
        
        for (int i = 0; i < 4; i++) {
            if (checkList[i][0] > -1 && checkList[i][0] < maxLength &&
               checkList[i][1] > -1 && checkList[i][1] < maxLength) {
                int nowH = checkList[i][0];
                int nowW = checkList[i][1];
                
                if (baseColor.equals(board[nowH][nowW])) {
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
}

// 다른 사람 풀이
class Solution_Other {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String sC = board[h][w];

        if(h > 0 && sC.equals(board[h-1][w])) answer++;
        if(h < board.length - 1 && sC.equals(board[h+1][w])) answer++;
        if(w > 0 && sC.equals(board[h][w-1])) answer++;
        if(w < board[h].length - 1 && sC.equals(board[h][w+1])) answer++;
        return answer;
    }
}
