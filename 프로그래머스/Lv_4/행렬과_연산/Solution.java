/*
 * 프로그래머스 - 행렬과 연산
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/118670
 */
package Lv_4.행렬과_연산;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = new int[rc.length][rc[0].length];

        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> right = new LinkedList<>();
        Deque<Deque<Integer>> middle = new LinkedList<>();

        for (int[] r : rc) {
            middle.add(new LinkedList<>());

            for (int i = 0; i < r.length; i++) {
                if (i == 0) left.add(r[i]);
                else if (i == rc[0].length - 1) right.add(r[i]);
                else middle.peekLast().add(r[i]);
            }
        }

        for (String operation : operations) {
            if (operation.equals("Rotate")) {
                middle.peek().addFirst(left.poll());
                right.addFirst(middle.peek().pollLast());
                middle.peekLast().add(right.pollLast());
                left.add(middle.peekLast().poll());
            } else {
                left.addFirst(left.pollLast());
                right.addFirst(right.pollLast());
                middle.addFirst(middle.pollLast());
            }
        }

        for (int row = 0; row < rc.length; row++) {
            int col = 0;

            answer[row][col++] = left.poll();
            for (int poll : middle.poll()) answer[row][col++] = poll;
            answer[row][col] = right.poll();
        }

        return answer;
    }
}
