/*
 * 24/03/20
 *
 * 프로그래머스 - 성격 유형 검사하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */
package 성격유형검사하기;

import java.util.HashMap;

// 내 풀이
class Solution {
	public String solution(String[] survey, int[] choices) {
		String answer = "";

		// 2개씩 사전 순서대로 기입
		char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

		// init 점수 맵
		HashMap<Character, Integer> pointMap = new HashMap<>();
		for (char c : types) {
			pointMap.put(c, 0);
		}

		// 점수 맵에 기입
		for (int i = 0; i < survey.length; i++) {
			if ((choices[i] - 4) > 0) {
				int nowPoint = pointMap.get(survey[i].charAt(1));
				pointMap.put(survey[i].charAt(1), nowPoint + choices[i] - 4);
			} else if ((choices[i] - 4) < 0) {
				int nowPoint = pointMap.get(survey[i].charAt(0));
				pointMap.put(survey[i].charAt(0), nowPoint + 4 - choices[i]);
			}
		}

		// 성격 유형 확인 (2개씩)
		for (int i = 0; i < types.length; i += 2) {
			if (pointMap.get(types[i]) >= pointMap.get(types[i + 1])) {
				answer += types[i];  // 점수가 서로 같을 경우 사전 순서
			} else {
				answer += types[i + 1];
			}
		}

		return answer;
	}
}

// 다른 사람 풀이
// import java.util.HashMap;
//
// class Solution_Other {
//     public String solution(String[] survey, int[] choices) {
//         String answer = "";
//         char [][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
//         int [] score = {0, 3, 2, 1, 0, 1, 2, 3};
//         HashMap<Character, Integer> point = new HashMap<Character, Integer>();
//
//         // 점수 기록할 배열 초기화
//         for (char[] t : type) {
//             point.put(t[0], 0);
//             point.put(t[1], 0);
//         }
//
//         // 점수 기록
//         for (int idx = 0; idx < choices.length; idx++){
//             if(choices[idx] > 4){
//                 point.put(survey[idx].charAt(1), point.get(survey[idx].charAt(1)) + score[choices[idx]]);
//             } else {
//                 point.put(survey[idx].charAt(0), point.get(survey[idx].charAt(0)) + score[choices[idx]]);
//             }
//         }
//
//         // 지표 별 점수 비교 후 유형 기입
//         for (char[] t : type) {
//             answer += (point.get(t[1]) <= point.get(t[0])) ? t[0] : t[1];
//         }
//
//         return answer;
//     }
// }
