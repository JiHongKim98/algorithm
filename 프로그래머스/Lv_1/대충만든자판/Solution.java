/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
 */
package Lv_1.대충만든자판;

import java.util.HashMap;
import java.util.Map;

class Solution {

	public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];

		Map<String, Integer> minKey = new HashMap<>();
		for (String key : keymap) {
			String[] split = key.split("");

			for (int i = 0; i < split.length; i++) {
				int num = minKey.getOrDefault(split[i], i + 1);

				minKey.put(split[i], Math.min(num, i + 1));
			}
		}

		for (int i = 0; i < targets.length; i++) {
			String[] split = targets[i].split("");

			for (String s : split) {
				if (minKey.containsKey(s)) {
					answer[i] += minKey.get(s);
				} else {
					answer[i] = -1;
					break;
				}
			}
		}

		return answer;
	}
}
