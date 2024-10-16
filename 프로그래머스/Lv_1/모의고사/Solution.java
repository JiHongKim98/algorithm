/*
 * 프로그래머스 - 모의고사
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
package Lv_1.모의고사;

import java.util.ArrayList;
import java.util.List;

class Solution {

	public int[] solution(int[] answers) {
		int[] tempAnswer = {0, 0, 0};

		int[] firUser = {1, 2, 3, 4, 5};
		int[] secUser = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] thrUser = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		for (int i = 0; i < answers.length; i++) {
			int fir = i % firUser.length;
			if (firUser[fir] == answers[i]) {
				tempAnswer[0]++;
			}

			int sec = i % secUser.length;
			if (secUser[sec] == answers[i]) {
				tempAnswer[1]++;
			}

			int thr = i % thrUser.length;
			if (thrUser[thr] == answers[i]) {
				tempAnswer[2]++;
			}
		}

		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			maxValue = Math.max(tempAnswer[i], maxValue);
		}

		List<Integer> user = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (tempAnswer[i] == maxValue) {
				user.add(i + 1);
			}
		}

		int size = user.size();
		int[] answer = new int[size];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = user.get(i);
		}

		return answer;
	}
}
