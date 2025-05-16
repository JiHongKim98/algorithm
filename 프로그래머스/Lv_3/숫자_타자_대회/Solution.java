/*
 * 프로그래머스 - 숫자 타자 대회
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/136797
 */
package Lv_3.숫자_타자_대회;

import java.util.Arrays;

class Solution {

    private char[] nums;
    private int[][][] dp;

    public int solution(String numbers) {
        nums = numbers.toCharArray();
        dp = new int[10][10][nums.length];

        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return DFS(4, 6, 0);
    }

    private int DFS(int left, int right, int idx) {
        if (idx == nums.length) return 0;
        if (dp[left][right][idx] != -1) return dp[left][right][idx];

        int num = nums[idx] - '0';
        int min = Integer.MAX_VALUE;

        if (num != right) {
            int leftDist = dist(left, num) + DFS(num, right, idx + 1);
            min = Math.min(min, leftDist);
        }

        if (num != left) {
            int rightDist = dist(right, num) + DFS(left, num, idx + 1);
            min = Math.min(min, rightDist);
        }

        dp[left][right][idx] = min;

        return min;
    }

    private int dist(int curr, int target) {
        int[] currPos = getIdx(curr);
        int[] targetPos = getIdx(target);

        int x = Math.abs(currPos[0] - targetPos[0]);
        int y = Math.abs(currPos[1] - targetPos[1]);

        if (x == 0 && y == 0) return 1;
        else return (Math.max(x, y) - Math.min(x, y)) * 2 + Math.min(x, y) * 3;
    }

    private int[] getIdx(int num) {
        if (num == 0) return new int[]{3, 1};
        return new int[]{(num - 1) / 3, (num - 1) % 3};
    }
}
