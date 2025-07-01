/*
 * 프로그래머스 - 소수 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12977
 */
package Lv_1.소수_만들기;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] nums) {
        List<Integer> map = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    map.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        int answer = 0;
        for (int num : map) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
