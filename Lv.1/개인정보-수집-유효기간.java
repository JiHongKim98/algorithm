/*
 * 24/03/18
 * 
 * 프로그래머스 - 개인정보 수집 유효기간
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 */

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // <약관 종류, 기간(개월)>
        Map<String, Integer> termMap = new HashMap<>();
        for (String term: terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]) * 28);
        }
        
        // 오늘 날짜
        int nowTime = paserTime(today);
        
        // 날짜 검증
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            
            int tempTime = paserTime(split[0]);
            int termTime = termMap.get(split[1]);
            
            // 기간이 지난 경우 -> 삭제해야함
            if (nowTime >= tempTime + termTime) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream()
            .mapToInt(integer -> integer)
            .toArray();
    }
    
    private int paserTime(String stringDate) {
        String[] todaySplit = stringDate.split("\\.");
        
        int tempYear = (Integer.parseInt(todaySplit[0]) - 2000) * 12 * 28;
        int tempMonth = Integer.parseInt(todaySplit[1]) * 28;
        int tempDay = Integer.parseInt(todaySplit[2]);
        return tempYear + tempMonth + tempDay;
    }
}