/*
 * 프로그래머스 - 직사각형의 넓이
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12974
 */
package Lv_5.직사각형의_넓이;

import java.util.*;

class Solution {

    class Event implements Comparable<Event> {
        int x;
        int y1;
        int y2;
        int type;

        Event(int x, int y1, int y2, int type) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.type = type;
        }

        public int compareTo(Event o) {
            return Integer.compare(this.x, o.x);
        }
    }

    class SegmentTree {
        int[] count;
        int[] yCoords;
        long[] length;

        SegmentTree(int n, int[] yCoords) {
            this.yCoords = yCoords;
            this.count = new int[n * 4];
            this.length = new long[n * 4];
        }

        void update(int node, int left, int right, int updateLeft, int updateRight, int type) {
            if (left >= updateRight || right <= updateLeft) return;

            if (left >= updateLeft && right <= updateRight) {
                count[node] += type;
            } else {
                int mid = (left + right) / 2;
                update(node * 2, left, mid, updateLeft, updateRight, type);
                update(node * 2 + 1, mid, right, updateLeft, updateRight, type);
            }

            if (count[node] > 0) length[node] = yCoords[right] - yCoords[left];
            else if (right - left == 1) length[node] = 0;
            else length[node] = length[node * 2] + length[node * 2 + 1];
        }

        long query() {
            return length[1];
        }
    }

    public long solution(int[][] rectangles) {
        Set<Integer> ySet = new HashSet<>();
        List<Event> events = new ArrayList<>();

        for (int[] rect : rectangles) {
            ySet.add(rect[1]);
            ySet.add(rect[3]);
            events.add(new Event(rect[0], rect[1], rect[3], 1));  // x1, y1, y2, 시작
            events.add(new Event(rect[2], rect[1], rect[3], -1));  // x2, y1, y2, 끝
        }

        int[] yCoords = ySet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(yCoords);

        Map<Integer, Integer> yIndex = new HashMap<>();
        for (int i = 0; i < yCoords.length; i++) yIndex.put(yCoords[i], i);

        SegmentTree tree = new SegmentTree(yCoords.length - 1, yCoords);
        Collections.sort(events);

        long answer = 0;
        int prevX = events.get(0).x;
        for (Event event : events) {
            int currXLen = event.x - prevX;
            long coverYLen = tree.query();
            answer += currXLen * coverYLen;

            int updateLeft = yIndex.get(event.y1);
            int updateRight = yIndex.get(event.y2);
            tree.update(1, 0, yCoords.length, updateLeft, updateRight, event.type);

            prevX = event.x;
        }

        return answer;
    }
}
