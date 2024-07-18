/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250135
 */
package Lv_2.아날로그시계;

// 현재 시간에 알람이 울리는 경우를 생각해야한다..

class Solution {

	public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
		int answer = -1;

		int startTime = getSeconds(h1, m1, s1);
		int endTime = getSeconds(h2, m2, s2);

		int diffAlarmCount = getAlarmCountByZeroOClock(endTime) - getAlarmCountByZeroOClock(startTime);

		return diffAlarmCount + isAlarmNow(startTime);
	}

	private int getSeconds(int hour, int min, int sec) {
		return sec + (min * 60) + (hour * 60 * 60);
	}

	private int getAlarmCountByZeroOClock(int secTime) {
		int alamPerMin = secTime * (60 - 1) / (60 * 60);
		int alamPerHour = secTime * (60 * 12 - 1) / (60 * 60 * 12);

		if (secTime < (60 * 60 * 12)) {
			return alamPerMin + alamPerHour - 1;
		}
		return alamPerMin + alamPerHour - 2;
	}

	private int isAlarmNow(int secTime) {
		if (
			secTime * (60 - 1) % (60 * 60) == 0 ||
				secTime * (60 * 12 - 1) % (60 * 60 * 12) == 0
		) {
			return 1;
		}
		return 0;
	}
}
