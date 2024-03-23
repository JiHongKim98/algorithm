/*
 * 24/03/23
 * 
 * 프로그래머스 - 데이터 분석
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/250121
 */

// 내 풀이
import java.util.*;

class Solution_Me {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] exts = {"code", "date", "maximum", "remain"};
        int indexNum = -1;
        int sortNum = -1;
        
        for (int i = 0; i < 4; i++) {
            if (exts[i].equals(ext)) {
                indexNum = i;
                System.out.println(indexNum);
            }
            
            if (exts[i].equals(sort_by)) {
                sortNum = i;
                System.out.println(sortNum);
            }
        }
        
        List<int[]> answer = new ArrayList<>();
        
        for (int[] _data: data) {
            if (_data[indexNum] < val_ext) {
                answer.add(_data);
            }
        }
        
        final int _sortNum = sortNum;
        
        Collections.sort(answer, (Comparator.comparingInt(o -> o[_sortNum])));
        
        return answer;
    }
}

// 다른 사람 풀이
// import java.util.*;

class Solution_Other {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> colOrder = new HashMap<>();
        colOrder.put("code", 0);
        colOrder.put("date", 1);
        colOrder.put("maximum", 2);
        colOrder.put("remain", 3);
        
        int[][] filteredData = Arrays.stream(data).filter(x -> x[colOrder.get(ext)] < val_ext).toArray(int[][]::new);
        Arrays.sort(filteredData, (o1, o2) ->  o1[colOrder.get(sort_by)] - o2[colOrder.get(sort_by)]);

        return filteredData;
    }
}
