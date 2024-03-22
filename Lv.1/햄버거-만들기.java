/*
 * 24/03/22
 * 
 * 프로그래머스 - 햄버거 만들기
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/133502
 */

// 내 풀이
import java.util.*;

class Solution_Me {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> st = new Stack<>();
        
        for (int temp: ingredient) {
            st.push(temp);
            
            if (st.size() >= 4) {
                
                if (st.get(st.size() - 4) == 1 &&
                   st.get(st.size() - 3) == 2 &&
                   st.get(st.size() - 2) == 3 &&
                   st.get(st.size() - 1) == 1) {
                    answer += 1;
                    
                    st.pop();
                    st.pop();
                    st.pop();
                    st.pop();
                }
            }
        }
        
        return answer;
    }
}

// 다른 사람 풀이
class Solution {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                && stack[sp - 2] == 3
                && stack[sp - 3] == 2
                && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }
}
