/*
 * 프로그래머스 - 문자열의 아름다움
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/68938
 */
package Lv_5.문자열의_아름다움;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long solution(String s) {
        Map<Character, Map<Integer, Integer>> segMap = new HashMap<>();

        int n = s.length();
        int idx = 0;
        while (idx < n) {
            int startIdx = idx;
            char curr = s.charAt(idx);

            while (idx < n && s.charAt(idx) == curr) idx++;

            int segLen = idx - startIdx;
            Map<Integer, Integer> lenCountMap = segMap.getOrDefault(curr, new HashMap<>());
            lenCountMap.put(segLen, lenCountMap.getOrDefault(segLen, 0) + 1);
            segMap.put(curr, lenCountMap);
        }

        long answer = (long) (n - 1) * n * (n + 1) / 6;

        for (Map<Integer, Integer> lenCountMap : segMap.values()) {
            int maxSegLen = 0;

            int totSegCount = 0;
            int totSegLength = 0;

            for (Map.Entry<Integer, Integer> lenCount : lenCountMap.entrySet()) {
                int len = lenCount.getKey();
                int count = lenCount.getValue();

                if (len > maxSegLen) maxSegLen = len;

                totSegCount += count;
                totSegLength += len * count;
            }

            int currSegLen = totSegLength;
            int currSegCount = totSegCount;

            for (int len = 1; len <= maxSegLen; len++) {
                answer -= (long) currSegLen * (currSegLen - 1) / 2;

                currSegLen -= currSegCount;
                currSegCount -= lenCountMap.getOrDefault(len, 0);
            }
        }
        return answer;
    }
}
