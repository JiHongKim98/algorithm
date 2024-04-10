/*
 * 24/03/19
 *
 * 프로그래머스 - 붕대 감기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/250137
 */
package 붕대감기;

class Solution {
	public int solution(int[] bandage, int health, int[][] attacks) {
		int count = bandage[0];  // 연속 회복 성공 횟수

		int maxhealth = health;  // 최대 체력

		int lastAttackTime = 0;  // 마지막 공격 시간

		for (int[] attack : attacks) {
			int tempTime = attack[0] - lastAttackTime - 1;  // 공격 받기 전까지의 시간 차이
			int bonusHealth = tempTime / count;  // 보너스 회복량 횟수

			// 공격 받은 시간 갱신
			lastAttackTime = attack[0];

			// 공격 받기까지 회복량 계산
			health = Math.min(maxhealth, health + (tempTime * bandage[1]));
			health = Math.min(maxhealth, health + (bonusHealth * bandage[2]));

			health -= attack[1];

			if (health <= 0) {  // 종료 조건
				return -1;
			}
		}

		return health;
	}
}
