/*
 * 24/03/28
 * 
 * 프로그래머스 - 실패율
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 */

// 내 풀이
import java.util.*;

class Solution_Me {
    public List<Integer> solution(int N, int[] stages) {
        // 각 스테이지에 도달한 players 계산
        int[] tempStage = new int[N];
        
        for (int stage: stages) {
            if (stage > N) continue;
            
            tempStage[stage - 1] += 1;
        }
        
        // 스테이지 실패율 계산
        int totP = stages.length;  // 총 player
        double[] failRates = new double[N];  // 각 스테이지의 실패율
        
        for (int i = 0; i < N; i++) {
            if (totP == 0) {  // 해당 스테이지 (i 스테이지) 에 사용자가 없는 경우
                failRates[i] = 0;
            } else {
                failRates[i] = (double) tempStage[i] / totP;
                totP = totP - tempStage[i];
            }
        }
        
        // 큰 수부터 내림차순 정렬
        List<Integer> answer = new ArrayList<>();
        
        Integer[] indexArray = new Integer[N];
        for (int i = 0; i < N; i++) {
            indexArray[i] = i;
        }
        
        Arrays.sort(indexArray, (a, b) -> {
            if (failRates[a] == failRates[b]) {
                return a - b;  // 값이 같은 경우 idx 가 작은 순
            }
            return Double.compare(failRates[b], failRates[a]);  // 내림차순
        });
        
        for (int i = 0; i < N; i++) {
            answer.add(indexArray[i] + 1);
        }
        
        return answer;
    }
}

// 다른 사람 풀이
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

class Solution_Other {
    public int[] solution(int N, int[] stages) {
    	// 스테이지별 도달했으나 클리어하지 못한 사람 수
        int[] currentStages = new int[N + 1];
        // 스테이지별 도달한 사람 수
        int[] clearStages = new int[N + 1];

        for (int i = 0; i < stages.length; i++) {
            // 스테이지에 도달한 플레이어 수 증가
            for (int j = 0; j < stages[i]; j++) {
                clearStages[j] += 1;
            }
            // 도달 했으나 클리어하지 못한 플레이어 수 증가
            currentStages[stages[i] - 1] += 1;
        }

        // 스테이지 번호와 실패율을 저장할 map
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            // 스테이지에 도달한 사람이 없거나 클리어한 사람이 없는 경우
            if (currentStages[i] == 0 || clearStages[i] == 0) {
                map.put(i + 1, 0.0);
            } else {
                // 실패율 계산하여 맵에 저장
                map.put(i + 1, (double) currentStages[i] / (double) clearStages[i]);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        // 실패율을 기준으로 내림차순 정렬
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

        // 리스트를 배열로 변환하여 반환
        return list.stream().mapToInt(i -> i).toArray();
    }
}
