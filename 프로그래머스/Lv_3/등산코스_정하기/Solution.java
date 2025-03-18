/*
 * 프로그래머스 - 등산코스 정하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/118669
 */
package Lv_3.등산코스_정하기;

import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] path : paths) {
            map.get(path[0]).add(new int[]{path[1], path[2]});
            map.get(path[1]).add(new int[]{path[0], path[2]});
        }

        Set<Integer> gateSet = new HashSet<>();
        Set<Integer> summitSet = new HashSet<>();
        for (int gate : gates) gateSet.add(gate);
        for (int summit : summits) summitSet.add(summit);

        int[] intensityMap = new int[n + 1];
        Arrays.fill(intensityMap, Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int gate : gates) {
            queue.add(new int[]{gate, 0});
            intensityMap[gate] = 0;
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currNode = poll[0];
            int currMaxDist = poll[1];

            // 현재 경로가 기존 intensity보다 크면 탐색할 필요 없음
            if (currMaxDist > intensityMap[currNode]) continue;

            for (int[] curr : map.get(currNode)) {
                int nextNode = curr[0];
                int nextDist = Math.max(currMaxDist, curr[1]);

                // 산봉우리이면 더 이상 탐색 X
                if (summitSet.contains(nextNode)) {
                    if (nextDist < intensityMap[nextNode]) {
                        intensityMap[nextNode] = nextDist;
                    }
                    continue;
                }

                // 더 작은 intensity로 갈 수 있으면 갱신 후 큐에 추가
                if (nextDist < intensityMap[nextNode]) {
                    intensityMap[nextNode] = nextDist;
                    queue.add(new int[]{nextNode, nextDist});
                }
            }
        }

        for (int summit : summits) {
            if (intensityMap[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = intensityMap[summit];
            } else if (intensityMap[summit] == answer[1] && summit < answer[0]) {
                answer[0] = summit;
            }
        }

        return answer;
    }
}
