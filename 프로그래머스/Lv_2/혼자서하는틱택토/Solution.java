/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/160585
 */
package Lv_2.혼자서하는틱택토;

class Solution {

	public int solution(String[] board) {
		String[][] boardMap = new String[3][3];

		int oCount = 0;
		int xCount = 0;

		for (int i = 0; i < 3; i++) {
			String[] map = board[i].split("");

			for (int j = 0; j < 3; j++) {
				boardMap[i][j] = map[j];

				if ("O".equals(map[j]))
					oCount++;

				if ("X".equals(map[j]))
					xCount++;
			}
		}

		if (xCount - oCount > 0 || oCount - xCount > 1) {
			return 0;
		}

		boolean oWin = isWin("O", boardMap);
		boolean xWin = isWin("X", boardMap);

		if (oWin && xCount + 1 != oCount)
			return 0;

		if (xWin && xCount != oCount)
			return 0;

		return 1;
	}

	private boolean isWin(String target, String[][] map) {
		for (int i = 0; i < 3; i++) {
			if (
				map[i][0].equals(target) &&
					map[i][1].equals(target) &&
					map[i][2].equals(target)
			)
				return true;
		}

		for (int i = 0; i < 3; i++) {
			if (
				map[0][i].equals(target) &&
					map[1][i].equals(target) &&
					map[2][i].equals(target)
			)
				return true;
		}

		if (
			map[0][0].equals(target) &&
				map[1][1].equals(target) &&
				map[2][2].equals(target)
		)
			return true;

		if (
			map[2][0].equals(target) &&
				map[1][1].equals(target) &&
				map[0][2].equals(target)
		)
			return true;

		return false;
	}
}
