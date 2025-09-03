/*
 * 프로그래머스 - 캐릭터의 좌표
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/120861
 */
package Lv_0.캐릭터의_좌표;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int rl = 0;
        int ud = 0;

        int maxRL = (board[0] - 1) / 2;
        int maxUD = (board[1] - 1) / 2;

        for (String key : keyinput) {
            if (key.equals("right")) rl = Math.min(maxRL, rl + 1);
            else if (key.equals("left")) rl = Math.max(-1 * maxRL, rl - 1);
            else if (key.equals("up")) ud = Math.min(maxUD, ud + 1);
            else ud = Math.max(-1 * maxUD, ud - 1);
        }

        return new int[]{rl, ud};
    }
}
