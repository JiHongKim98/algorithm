/*
 * 프로그래머스 - 불량 사용자
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/64064
 */
package Lv_3.불량_사용자;

import java.util.HashSet;
import java.util.Set;

class Solution {

    private static String[] userIds;
    private static String[] bannedIds;
    private static HashSet<HashSet<String>> answer;

    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        answer = new HashSet<>();

        dfs(new HashSet(), 0);

        return answer.size();
    }

    private void dfs(Set map, int count) {
        if (count == bannedIds.length) {
            answer.add(new HashSet<>(map));
            return;
        }

        for (String userId : userIds) {
            if (
                    isBanned(userId, bannedIds[count]) &&
                            map.add(userId)
            ) {
                dfs(map, count + 1);

                map.remove(userId);
            }
        }
    }

    private boolean isBanned(String target, String bannedId) {
        int len = target.length();

        if (len != bannedId.length()) return false;

        for (int i = 0; i < len; i++) {
            if (target.charAt(i) != bannedId.charAt(i) && bannedId.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
