/*
 * 프로그래머스 - 베스트앨범
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */
package Lv_3.베스트앨범;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	public int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> genrePlayMap = new HashMap<>();
		Map<String, ArrayList<int[]>> genreSongPlayMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			genrePlayMap.put(genres[i], genrePlayMap.getOrDefault(genres[i], 0) + plays[i]);

			genreSongPlayMap.putIfAbsent(genres[i], new ArrayList<>());
			genreSongPlayMap.get(genres[i]).add(new int[] {i, plays[i]});
		}

		List<String> sortedGenres = new ArrayList<>(genrePlayMap.keySet());
		sortedGenres.sort((o1, o2) -> genrePlayMap.get(o2) - genrePlayMap.get(o1));

		ArrayList<Integer> answer = new ArrayList<>();

		for (String genre : sortedGenres) {
			List<int[]> songs = genreSongPlayMap.get(genre);
			songs.sort((o1, o2) -> {
				if (o2[1] != o1[1]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			});

			answer.add(songs.get(0)[0]);
			if (songs.size() > 1) {
				answer.add(songs.get(1)[0]);
			}
		}
		return answer.stream().mapToInt(i -> i).toArray();
	}
}
