/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/250121
 */
package Lv_1.데이터분석;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

	public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
		String[] exts = {"code", "date", "maximum", "remain"};
		int indexNum = -1;
		int sortNum = -1;

		for (int i = 0; i < 4; i++) {
			if (exts[i].equals(ext)) {
				indexNum = i;
				System.out.println(indexNum);
			}

			if (exts[i].equals(sort_by)) {
				sortNum = i;
				System.out.println(sortNum);
			}
		}

		List<int[]> answer = new ArrayList<>();

		for (int[] _data : data) {
			if (_data[indexNum] < val_ext) {
				answer.add(_data);
			}
		}

		final int _sortNum = sortNum;

		answer.sort((Comparator.comparingInt(o -> o[_sortNum])));

		return answer;
	}
}
