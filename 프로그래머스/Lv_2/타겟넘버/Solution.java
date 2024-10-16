/*
 * 프로그래머스 - 타겟넘버
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
package Lv_2.타겟넘버;

class Solution {

	private int targetNum;
	private int[] numberList;

	public int solution(int[] numbers, int target) {
		numberList = numbers;
		targetNum = target;
		return DFS(0, 0);
	}

	private int DFS(int nowSum, int count) {
		if (count == numberList.length) {
			if (nowSum == targetNum) {
				return 1;
			}
			return 0;
		}
		return DFS(nowSum + numberList[count], count + 1) +
			DFS(nowSum - numberList[count], count + 1);
	}
}
