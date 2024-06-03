/*
 * 24/03/18
 *
 * 프로그래머스 - 달리기 경주 문제
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
package Lv_1.달리기경주;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public String[] solution(String[] players, String[] callings) {
		String[] answer = players;  // 현재 순위 List
		Map<String, Integer> rankMap = new HashMap<>();  // 최신 순위 반영을 위한 Map

		// init rankMap
		for (int i = 0; i < players.length; i++) {
			rankMap.put(players[i], i);
		}

		for (String callName : callings) {
			// 현재 이름이 불린 사람의 순위
			int rank = rankMap.get(callName);

			// 추월당한 사람의 순위
			String frontName = answer[rank - 1];

			// answer에 순위 반영
			answer[rank] = frontName;
			answer[rank - 1] = callName;

			// rankMap에 순위 반영
			rankMap.put(callName, rank - 1);
			rankMap.put(frontName, rank);
		}

		return answer;
	}
}
