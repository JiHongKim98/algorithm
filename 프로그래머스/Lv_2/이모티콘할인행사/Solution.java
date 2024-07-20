/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/150368
 */
package Lv_2.이모티콘할인행사;

class Solution {

	private final int[] discountRates = {10, 20, 30, 40};

	private static int[] answer = new int[2];

	private int maxEmoticons;
	private int[] discountMap;

	public int[] solution(int[][] users, int[] emoticons) {
		maxEmoticons = emoticons.length;
		discountMap = new int[maxEmoticons];

		DFS(users, emoticons, 0);

		return answer;
	}

	private void DFS(int[][] users, int[] emoticons, int count) {

		if (count >= maxEmoticons) {
			cal(users, emoticons);
			return;
		}

		for (int discountRate : discountRates) {
			discountMap[count] = discountRate;

			DFS(users, emoticons, count + 1);
		}
	}

	private void cal(int[][] users, int[] emoticonMap) {

		int emoticonPlusCount = 0;
		int userTotalPrice = 0;

		for (int[] user : users) {
			int userDiscount = user[0];
			int userMaxPrice = user[1];

			int userPrice = 0;

			for (int i = 0; i < emoticonMap.length; i++) {
				if (userDiscount <= discountMap[i]) {
					userPrice += emoticonMap[i] / 100 * (100 - discountMap[i]);
				}
			}

			if (userMaxPrice <= userPrice)
				emoticonPlusCount++;
			else
				userTotalPrice += userPrice;
		}

		// 조건 1.이모티콘 플러스 서비스 가입자를 최대한 늘리는 것
		if (emoticonPlusCount > answer[0]) {
			answer[0] = emoticonPlusCount;
			answer[1] = userTotalPrice;
			return;
		}

		// 조건 2.이모티콘 판매액을 최대한 늘리는 것
		if (
			(emoticonPlusCount == answer[0]) &&  // 이모티콘 플러스 가입자수가 동일한 경우
				(userTotalPrice > answer[1])  // 이모티콘 판매액을 최대로 늘리는 것
		) {
			answer[1] = userTotalPrice;
			return;
		}
	}
}
