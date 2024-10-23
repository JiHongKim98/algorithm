/*
 * 프로그래머스 - 여행경로
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 */
package Lv_3.여행경로;

import java.util.ArrayList;
import java.util.Collections;

class Solution {

	private final static String DETERMINE = ",";

	private int maxTicket;
	private String[][] ticketMap;
	private boolean[] visitMap;
	private ArrayList<String> answerMap;

	public String[] solution(String[][] tickets) {
		maxTicket = tickets.length;

		ticketMap = tickets;
		visitMap = new boolean[maxTicket];
		answerMap = new ArrayList<>();

		DFS("ICN", "ICN", 0);

		Collections.sort(answerMap);

		String answer = answerMap.get(0);
		return answer.split(DETERMINE);
	}

	private void DFS(String currPoint, String route, int count) {
		if (count == maxTicket) {
			answerMap.add(route);
			return;
		}

		for (int i = 0; i < maxTicket; i++) {
			if (
				!visitMap[i]
					&& ticketMap[i][0].equals(currPoint)
			) {
				visitMap[i] = true;
				DFS(ticketMap[i][1], route + DETERMINE + ticketMap[i][1], count + 1);
				visitMap[i] = false;
			}
		}
	}
}
