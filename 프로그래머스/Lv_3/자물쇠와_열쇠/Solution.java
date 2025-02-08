/*
 * 프로그래머스 - 자물쇠와 열쇠
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/60059
 */
package Lv_3.자물쇠와_열쇠;

class Solution {

    private static int[][] keyMap;
    private static int[][] lockMap;

    public boolean solution(int[][] key, int[][] lock) {
        keyMap = key;
        lockMap = lock;

        for (int i = 0; i < 4; i++) {
            keySpin();

            for (int x = 1 - lockMap.length; x < lockMap.length - 1; x++) {
                for (int y = 1 - lockMap[0].length; y < lockMap[0].length - 1; y++) {
                    if (isPossible(x, y)) return true;
                }
            }
        }
        return false;
    }

    private boolean isPossible(int x, int y) {
        for (int i = 0; i < lockMap.length; i++) {
            for (int j = 0; j < lockMap[0].length; j++) {
                int nowX = i + x;
                int nowY = j + y;

                if (
                        nowX >= 0 && nowX < keyMap.length &&
                                nowY >= 0 && nowY < keyMap.length
                ) {
                    if (
                            (keyMap[nowX][nowY] == 0 && lockMap[i][j] == 0) ||
                                    (keyMap[nowX][nowY] == 1 && lockMap[i][j] == 1)
                    ) {
                        return false;
                    }
                } else {
                    if (lockMap[i][j] == 0) return false;  // 열쇠가 있어야하는데 없음
                }
            }
        }
        return true;
    }

    private void keySpin() {
        int[][] newMap = new int[keyMap.length][keyMap.length];
        for (int i = 0; i < keyMap.length; i++) {
            for (int j = 0; j < keyMap.length; j++) {
                newMap[i][j] = keyMap[keyMap.length - j - 1][i];
            }
        }
        keyMap = newMap;
    }
}
