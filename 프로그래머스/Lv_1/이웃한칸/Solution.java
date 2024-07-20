/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250125
 */
package Lv_1.이웃한칸;

class Solution {

	public int solution(String[][] board, int h, int w) {
		int answer = 0;

		String baseColor = board[h][w];
		int maxLength = board.length;

		int[][] checkList = {{h - 1, w}, {h + 1, w}, {h, w - 1}, {h, w + 1}};

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
