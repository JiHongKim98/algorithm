package Lv_3.퍼즐_조각_채우기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {-1, 1, 0, 0};

	private ArrayList<ArrayList<int[]>> gamePuz;
	private ArrayList<ArrayList<int[]>> tablePuz;

	public int solution(int[][] game_board, int[][] table) {
		boolean[][] visitGame = new boolean[game_board.length][game_board[0].length];
		boolean[][] visitTable = new boolean[table.length][table[0].length];

		gamePuz = new ArrayList<>();
		tablePuz = new ArrayList<>();

		for (int i = 0; i < game_board.length; i++) {
			for (int j = 0; j < table.length; j++) {
				if (!visitGame[i][j] && game_board[i][j] == 0) {
					visitGame[i][j] = true;
					BFS(new int[] {i, j}, game_board, visitGame, gamePuz, 0);
				}

				if (!visitTable[i][j] && table[i][j] == 1) {
					visitTable[i][j] = true;
					BFS(new int[] {i, j}, table, visitTable, tablePuz, 1);
				}
			}
		}

		int answer = 0;
		boolean[] visit = new boolean[tablePuz.size()];
		for (int i = 0; i < gamePuz.size(); i++) {
			for (int j = 0; j < tablePuz.size(); j++) {
				if (!visit[j]) {
					if (
						(tablePuz.get(j).size() == gamePuz.get(i).size())
							&& isPossible(gamePuz.get(i), tablePuz.get(j))
					) {
						visit[j] = true;
						answer += tablePuz.get(j).size();
						break;
					}
				}
			}
		}
		return answer;
	}

	public boolean isPossible(ArrayList<int[]> tablePuzList, ArrayList<int[]> boardPuzList) {
		boardPuzList.sort((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		for (int i = 0; i < 4; i++) {
			tablePuzList.sort((o1, o2) -> {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			});

			int currX = tablePuzList.get(0)[0];
			int currY = tablePuzList.get(0)[1];

			for (int[] tablePuz : tablePuzList) {
				tablePuz[0] -= currX;
				tablePuz[1] -= currY;
			}

			boolean isPossibleFlag = true;
			for (int j = 0; j < boardPuzList.size(); j++) {
				if (
					boardPuzList.get(j)[0] != tablePuzList.get(j)[0]
						|| boardPuzList.get(j)[1] != tablePuzList.get(j)[1]
				) {
					isPossibleFlag = false;
					break;
				}
			}

			if (isPossibleFlag) {
				return true;
			}

			for (int[] tablePuz : tablePuzList) {
				int temp = tablePuz[0];
				tablePuz[0] = tablePuz[1];
				tablePuz[1] = -temp;
			}
		}
		return false;
	}

	private void BFS(
		int[] xy,
		int[][] map,
		boolean[][] currVisitMap,
		ArrayList<ArrayList<int[]>> puzMap,
		int puzzleTypeNum
	) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(xy);

		ArrayList<int[]> tempPuzMap = new ArrayList<>();
		tempPuzMap.add(new int[] {0, 0});

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();

			int currX = poll[0];
			int currY = poll[1];

			for (int i = 0; i < 4; i++) {
				int newX = currX + dx[i];
				int newY = currY + dy[i];

				if (
					(newX >= 0 && newX < map.length) &&
						(newY >= 0 && newY < map[0].length) &&
						!currVisitMap[newX][newY] &&
						map[newX][newY] == puzzleTypeNum
				) {
					queue.add(new int[] {newX, newY});
					currVisitMap[newX][newY] = true;
					tempPuzMap.add(new int[] {newX - xy[0], newY - xy[1]});
				}
			}
		}
		puzMap.add(tempPuzMap);
	}
}
