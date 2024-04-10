/*
 * 24/03/21
 *
 * 프로그래머스 - 약수의 합
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12928
 */
package 약수의합;

// 내 풀이
class Solution {
	public int solution(int n) {
		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				answer += i;
			}
		}

		return answer;
	}
}
