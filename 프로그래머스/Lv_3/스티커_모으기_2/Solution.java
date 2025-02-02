/*
 * 프로그래머스 - 스티커 모으기(2)
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12971
 */
package Lv_3.스티커_모으기_2;

class Solution {
    public int solution(int[] sticker) {
        // 스티커를 무조건 한개만 뗄 수 밖에 없는 경우
        if (sticker.length <= 3) {
            int answer = 0;
            for (int stick : sticker) {
                answer = Math.max(stick, answer);
            }
            return answer;
        }

        int[] stickDp = new int[sticker.length];  // 첫번째 스티커를 뗀 경우
        int[] nostickDp = new int[sticker.length];  // 두번째 스티커를 뗀 경우

        stickDp[0] = sticker[0];
        stickDp[1] = sticker[0];

        nostickDp[0] = 0;
        nostickDp[1] = sticker[1];

        for (int i = 2; i < sticker.length; i++) {
            stickDp[i] = Math.max(stickDp[i - 2] + sticker[i], stickDp[i - 1]);
            nostickDp[i] = Math.max(nostickDp[i - 2] + sticker[i], nostickDp[i - 1]);
        }

        return Math.max(stickDp[sticker.length - 2], nostickDp[sticker.length - 1]);
    }
}
