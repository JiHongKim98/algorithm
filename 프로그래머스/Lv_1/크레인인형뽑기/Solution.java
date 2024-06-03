/*
 * 24/03/22
 *
 * 프로그래머스 - 크레인 인형 뽑기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 */
package Lv_1.크레인인형뽑기;

import java.util.Stack;

// 내 풀이
class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> bucket = new Stack<>();

		for (int move : moves) {
			move -= 1;

			for (int i = 0; i < board[0].length; i++) {

				if (board[i][move] != 0) {

					if (!bucket.isEmpty() && bucket.peek() == board[i][move]) {
						answer += 2;
						bucket.pop();
					} else {
						bucket.push(board[i][move]);
					}
					board[i][move] = 0;

					break;  // 1개만 꺼내고 종료
				}
			}
		}

		return answer;
	}
}

// 다른 사람 풀이
// import java.util.ArrayList;
// import java.util.List;
//
// class Solution_Other {
//     public int solution(int[][] board, int[] moves) {
//         int answer = 0;
//         List<Integer> nums = new ArrayList<Integer>();
//
//         for(int i=0;i<moves.length;i++){
//             for(int j=0;j<board.length;j++){
//                 if(board[j][moves[i]-1]!=0){
//                     nums.add(board[j][moves[i]-1]);
//                     board[j][moves[i]-1]=0;
//                     break;
//                 }
//
//             }
//
//         }
//         for(int k=0;k<nums.size();k++){
//             if(k!=(nums.size()-1)){
//                 if(nums.get(k)==nums.get(k+1)){
//                     nums.remove(k);
//                     nums.remove(k);
//                     answer++;
//                     k=-1;
//
//                 }
//
//             }
//         }
//
//         return answer*2;
//     }
// }
