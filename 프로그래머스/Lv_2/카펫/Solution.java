/*
 * 프로그래머스 - 카펫
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
package Lv_2.카펫;

class Solution {

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int total = brown + yellow;

		for (int i = 1; i <= brown; i++) {
			if (total % i == 0) {
				int result = total / i;

				if ((i - 2) * (result - 2) == yellow) {
					answer[0] = result;
					answer[1] = i;
					break;
				}
			}
		}

		return answer;
	}
}
