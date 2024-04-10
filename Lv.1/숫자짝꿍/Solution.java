/*
 * 24/03/22
 *
 * 프로그래머스 - 숫자 짝꿍
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131128
 */
package 숫자짝꿍;

// ※ 주의 ※
// !! StringBuilder 를 사용하지 않으면 시간 초과 뜸 !!

// 내 풀이
class Solution {
	public String solution(String X, String Y) {
		StringBuilder answer = new StringBuilder();

		int[] xMap = new int[10];  // 0~9 의 빈도수 Map
		int[] yMap = new int[10];

		resolveMap(X, xMap);
		resolveMap(Y, yMap);

		for (int i = 9; i >= 0; i--) {  // 가장 큰 숫자를 반환을 위해 역순으로 탐색
			while (xMap[i] > 0 && yMap[i] > 0) {
				xMap[i]--;
				yMap[i]--;

				answer.append(i);
			}
		}

		if (answer.toString().equals("")) {
			return "-1";
		} else if (answer.toString().startsWith("00")) {  // "00000", "0000", "000" 등 모두 "00" 으로 시작함
			return "0";
		} else {
			return answer.toString();
		}
	}

	private void resolveMap(String target, int[] map) {
		String[] temp = target.split("");

		for (int i = 0; i < target.length(); i++) {
			int nowNum = Integer.parseInt(temp[i]);
			map[nowNum] += 1;
		}
	}
}

// 다른 사람 풀이
// class Solution {
//     public String solution(String X, String Y) {
//         StringBuilder answer = new StringBuilder();
//
//         int[] arrX = new int[10];
//         int[] arrY = new int[10];
//
//         countNumInArr(X, arrX);
//         countNumInArr(Y, arrY);
//
//         for (int i = arrX.length - 1; i >= 0; i--) {
//             while (arrX[i] >= 1 && arrY[i] >= 1) {
//                 arrX[i]--;
//                 arrY[i]--;
//
//                 answer.append(i);
//             }
//         }
//
//         if (answer.toString().equals("")) {
//             return "-1";
//         } else if (answer.toString().startsWith("0")) {
//             return "0";
//         } else {
//             return answer.toString();
//         }
//     }
//
//     private void countNumInArr(String str, int[] arr) {
//         for (int i = 0; i < str.length(); i++) {
//             int index = str.charAt(i) - '0';
//
//             arr[index]++;
//         }
//     }
// }
