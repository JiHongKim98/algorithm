/*
 * 프로그래머스 - 그림 확대
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181836
 */
package Lv_0.그림_확대;

class Solution {
    public String[] solution(String[] picture, int k) {
        int row = picture.length * k;
        int col = picture[0].length() * k;

        String[] answer = new String[row];

        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();

            String curr = picture[i / k];
            for (int j = 0; j < col; j++) sb.append(curr.charAt(j / k));

            answer[i] = sb.toString();
        }

        return answer;
    }
}
