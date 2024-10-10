/*
 * 프로그래머스 - 동영상 재생
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/340213
 */
package Lv_1.동영상_재생기;

class Solution {

	private int opEnd;
	private int opStart;
	private int videoLen;

	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		videoLen = convertToSeconds(video_len);
		opStart = convertToSeconds(op_start);
		opEnd = convertToSeconds(op_end);
		int now = convertToSeconds(pos);

		now = movePosIfOpening(now);

		for (String command : commands) {
			now = doCommand(now, command);
		}

		return convertToString(now);
	}

	private int convertToSeconds(String timeToString) {
		String[] split = timeToString.split(":");
		int min = Integer.parseInt(split[0]);
		int sec = Integer.parseInt(split[1]);
		return (min * 60) + sec;
	}

	private String convertToString(int time) {
		int min = time / 60;
		int sec = time - (min * 60);

		String minString = String.valueOf(min);
		if (min < 10) {
			minString = "0" + minString;
		}

		String secString = String.valueOf(sec);
		if (sec < 10) {
			secString = "0" + secString;
		}

		return minString + ":" + secString;
	}

	private int doCommand(int now, String command) {
		if (command.equals("next")) {
			now = now + 10;
			if (now > videoLen) {
				now = videoLen;
			}
		}

		if (command.equals("prev")) {
			now = now - 10;
			if (now < 0) {
				now = 0;
			}
		}

		return movePosIfOpening(now);
	}

	private int movePosIfOpening(int now) {
		if (now >= opStart && now <= opEnd) {
			return opEnd;
		}
		return now;
	}
}
