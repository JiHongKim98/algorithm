/*
 * 프로그래머스 - 호텔 대실
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651
 */
package Lv_2.호텔_대실;

// 누적합
class Solution {
    public int solution(String[][] book_time) {
        int answer = -1;

        int[] rooms = new int[24 * 60 + 10];

        for (String[] strings : book_time) {
            int start = processTime(strings[0]);
            int end = processTime(strings[1]) + 10;

            rooms[start] += 1;
            rooms[end] -= 1;
        }

        for (int i = 1; i < 24 * 60 + 10; i++) {
            rooms[i] += rooms[i - 1];
            answer = Math.max(rooms[i], answer);
        }

        return answer;
    }

    private int processTime(String target) {
        String[] time = target.split(":");
        int h = Integer.parseInt(time[0]) * 60;
        int m = Integer.parseInt(time[1]);
        return h + m;
    }
}
