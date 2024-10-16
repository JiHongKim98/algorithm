/*
 * 프로그래머스 - 충돌위험 찾기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */
package Lv_2.n진수_게임;

class Solution {

	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();

		int number = 0;
		int nowTurn = 1;
		int sayCount = 0;

		while (t > sayCount) {
			String say = convertNum(n, number);

			for (int i = 0; i < say.length(); i++) {
				if (nowTurn == p) {
					sayCount++;
					sb.append(say.charAt(i));

					if (sayCount == t) {
						break;
					}
				}

				nowTurn++;
				if (nowTurn == m + 1) {
					nowTurn = 1;
				}
			}
			number++;
		}

		return sb.toString();
	}

	private String convertNum(int n, int nowNum) {
		if (nowNum == 0) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		while (nowNum > 0) {
			int remain = nowNum % n;
			if (remain >= 10) {
				sb.append((char)('A' + (remain - 10)));
			} else {
				sb.append(remain);
			}
			nowNum /= n;
		}

		return sb.reverse().toString();
	}
}

