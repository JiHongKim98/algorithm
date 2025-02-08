/*
 * 프로그래머스 - 풍선 터트리기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/68646
 */
package Lv_3.풍선_터트리기;

class Solution {
    public int solution(int[] a) {
        int answer = 2;  // 양끝은 어떤 방법으로도 살릴 수 있다.

        int[] leftMap = new int[a.length];
        leftMap[0] = a[0];
        for (int i = 1; i < a.length - 1; i++) {
            leftMap[i] = Math.min(leftMap[i - 1], a[i]);
        }

        int[] rightMap = new int[a.length];
        rightMap[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i > 0; i--) {
            rightMap[i] = Math.min(rightMap[i + 1], a[i]);
        }

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] > leftMap[i] && a[i] > rightMap[i]) continue;

            answer++;
        }

        return answer;
    }
}
