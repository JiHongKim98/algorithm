/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/152996
 */
package Lv_2.시소짝꿍;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

	public long solution(int[] weights) {
		long answer = 0;

		Arrays.sort(weights);
		Map<Double, Integer> map = new HashMap<>();

		for (int weight : weights) {
			double temp1 = weight * 1.0;  // (2.0 / 2.0)
			if (map.containsKey(temp1))
				answer += map.get(temp1);

			double temp2 = weight * 2.0 / 3.0;
			if (map.containsKey(temp2))
				answer += map.get(temp2);

			double temp3 = weight * 2.0 / 4.0;
			if (map.containsKey(temp3))
				answer += map.get(temp3);

			double temp4 = weight * 3.0 / 4.0;
			if (map.containsKey(temp4))
				answer += map.get(temp4);

			map.put(
				(weight * 1.0),
				map.getOrDefault((weight * 1.0), 0) + 1
			);
		}

		return answer;
	}
}
