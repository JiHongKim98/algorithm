/*
 * 프로그래머스 - 모음사

 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
package Lv_2.모음사전;

class Solution {

	private static final int[] weight = {781, 156, 31, 6, 1};
	private static final char[] characters = {'A', 'E', 'I', 'O', 'U'};

	public int solution(String word) {
		int idx = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int charPosition = findCharPosition(c);
			idx += charPosition * weight[i] + 1;
		}

		return idx;
	}

	private int findCharPosition(char ch) {
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] == ch) {
				return i;
			}
		}
		return -1;
	}
}

