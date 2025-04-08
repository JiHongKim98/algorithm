/*
 * 프로그래머스 - [3차] 방금그곡
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17683
 */
package Lv_2.삼차_방금그곡;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = sharpConvert(m);

        Map<String, Integer> map = new HashMap<>();

        int w = 100;  // 가중치
        for (String musicInfo : musicinfos) {
            String[] info = musicInfo.split(",");

            int currPlayTime = convertPlayTime(info[0], info[1]);

            String currMusic = sharpConvert(info[3]);
            int currMusicLength = currMusic.length();

            String playMusic = "";
            for (int i = 0; i < currPlayTime; i++) {
                playMusic += currMusic.charAt(i % currMusicLength);

                if (playMusic.contains(m)) {
                    String musicName = info[2];
                    map.put(musicName, currPlayTime * 1440 + w--);  // 동일한 값이 있는 경우 먼저 등록된 음악 반환
                }
            }
        }

        int currMaxWeight = Integer.MIN_VALUE;
        for (String key : map.keySet()) {
            if (map.get(key) > currMaxWeight) {
                currMaxWeight = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    private String sharpConvert(String str) {
        return str
                .replaceAll("A#", "a")
                .replaceAll("B#", "b")
                .replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("E#", "e")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g");
    }

    private int convertPlayTime(String start, String end) {
        String[] startSplit = start.split(":");
        String[] endSplit = end.split(":");

        int hour = (Integer.parseInt(endSplit[0]) - Integer.parseInt(startSplit[0])) * 60;
        int min = (Integer.parseInt(endSplit[1]) - Integer.parseInt(startSplit[1]));

        return hour + min + 1;
    }
}
