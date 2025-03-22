/*
 * 프로그래머스 - 스타 수열
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/70130
 */
package Lv_3.스타_수열;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] a) {
        if (a.length < 2) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int answer = 0;

        for (int curr : map.keySet()) {
            if (answer > map.get(curr) * 2) continue;  // 현재 필수 포함 숫자로는 최대값 생성 불가능한 경우

            int currAnswer = 0;

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] != a[i + 1] && (a[i] == curr || a[i + 1] == curr)) {
                    currAnswer += 2;
                    i++; // 쌍 완성시 다다음 탐색
                }
            }

            answer = Math.max(answer, currAnswer);
        }

        return answer;
    }
}
