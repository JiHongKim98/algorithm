/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/140108
 */
package Lv_1.문자열나누기;

class Solution {

	public int solution(String s) {
		int answer = 0;

		char charL = s.charAt(0);

		int correct = 0;
		int incorrect = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == charL) {
				correct += 1;
			} else {
				incorrect += 1;
			}

			if (correct == incorrect) {
				answer += 1;

				if (i < s.length() - 1) {
					charL = s.charAt(i + 1);
				}

			} else if (i == s.length() - 1) {
				answer += 1;
			}

		}

		return answer;
	}
}
