/*
 * 프로그래머스 - 두 큐 합 같게 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */
package Lv_2.두_큐_합_같게_만들기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int maxLen = queue1.length;
        int answer = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long q1Sum = 0;
        for (int q : queue1) {
            q1.add(q);
            q1Sum += q;
        }

        long q2Sum = 0;
        for (int q : queue2) {
            q2.add(q);
            q2Sum += q;
        }

        if (q1Sum == q2Sum) return 0;

        // 점화식 n * 2 + n - 1 최대
        // 111 5 | 11 51 | 1 511 | 15 11 | 5 111 | 51 11 |
        // 11111 117 | 111111 17 | 1111111 7 | 111111 71 | 11111 711 | 1111 7111 | 111 71111 | 11 711111 | 1 7111111 | 17 111111 | 7 1111111
        while (!q1.isEmpty() && !q2.isEmpty() && answer <= maxLen * 2 + maxLen - 1) {
            if (q1Sum > q2Sum) {
                int poll = q1.poll();
                q2.add(poll);
                q1Sum -= poll;
                q2Sum += poll;
            } else if (q1Sum < q2Sum) {
                int poll = q2.poll();
                q1.add(poll);
                q2Sum -= poll;
                q1Sum += poll;
            } else {
                return answer;
            }
            answer++;
        }

        return -1;
    }
}
