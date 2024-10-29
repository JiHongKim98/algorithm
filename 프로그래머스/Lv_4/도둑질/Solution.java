/*
 * 프로그래머스 - 도둑질
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42897
 */
package Lv_4.도둑질;

class Solution {

	public int solution(int[] money) {
		int answer = 0;

		int[] firList = new int[money.length + 1];
		int[] secList = new int[money.length + 1];

		firList[0] = 0;
		secList[0] = 0;

		for (int i = 1; i < money.length; i++) {
			firList[i] = money[i - 1];
			secList[i] = money[i];
		}

		for (int i = 2; i < money.length; i++) {
			firList[i] = Math.max(firList[i] + firList[i - 2], firList[i - 1]);
			secList[i] = Math.max(secList[i] + secList[i - 2], secList[i - 1]);
		}

		answer = Math.max(firList[money.length - 1], secList[money.length - 1]);
		return answer;
	}
}
