/*
 * 프로그래머스 - 브라이언의 고민
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/1830
 */
package Lv_3.브라이언의_고민;

class Solution {

    private final String INVALID = "invalid";

    private boolean[] usedMap;

    public String solution(String sentence) {
        usedMap = new boolean[26];

        int[] lowerCount = new int[26];

        for (char c : sentence.toCharArray()) {
            if (isLower(c)) {
                lowerCount[c - 'a']++;
            }
        }

        StringBuilder sb = new StringBuilder(sentence);

        int idx = 0;
        while (idx < sb.length()) {
            char currChar = sb.charAt(idx);

            if (!isLower(currChar)) {
                idx++;
                continue;
            }

            int endIdx = sb.lastIndexOf(String.valueOf(currChar));
            int count = lowerCount[currChar - 'a'];

            if (count == 2) {  // 소문자가 2번만 나온 경우
                String segment = sb.substring(idx, endIdx + 1);
                String checked = checkRule2(segment);

                if (INVALID.equals(checked)) return INVALID;

                sb.replace(idx, endIdx + 1, checked);
                idx += checked.length();
            } else if (count > 0) {  // 소문자가 1번 or 3번
                if (usedMap[currChar - 'a']) return INVALID;

                if (!isRuleOneValid(sb, idx, endIdx, count)) return INVALID;
                usedMap[currChar - 'a'] = true;

                String outer = sb.substring(idx - 1, endIdx + 2);
                String replaced = outer.replaceAll(String.valueOf(currChar), "");
                if (containsLower(replaced)) return INVALID;

                lowerCount[currChar - 'a'] = 0;
                sb.replace(idx - 1, endIdx + 2, " " + replaced + " ");

                idx = idx - 1 + replaced.length() + 2;
            } else {
                idx++;
            }
        }

        return sb.toString().trim().replaceAll(" +", " ");
    }

    private boolean isRuleOneValid(StringBuilder sb, int startIdx, int endIdx, int count) {
        if (startIdx == 0 || endIdx == sb.length() - 1) return false;
        if (isSpaceOrLower(sb.charAt(startIdx - 1)) || isSpaceOrLower(sb.charAt(endIdx + 1))) return false;
        return endIdx - startIdx == count * 2 - 2;
    }

    private boolean isSpaceOrLower(char c) {
        return c == ' ' || isLower(c);
    }

    private String checkRule2(String str) {
        if (str.length() <= 2) return INVALID;

        char firstInner = str.charAt(1);
        char lastInner = str.charAt(str.length() - 2);

        if (isLower(firstInner) || isLower(lastInner)) return INVALID;

        String replaced = str.replaceAll(String.valueOf(str.charAt(0)), " ");
        for (int idx = 1; idx < replaced.length() - 1; idx++) {
            char ch = replaced.charAt(idx);

            if (isLower(ch)) {
                int count = countChar(str, ch);
                if (usedMap[ch - 'a']) return INVALID;

                int endIdx = replaced.lastIndexOf(String.valueOf(ch));
                if (endIdx - idx != count * 2 - 2) return INVALID;

                usedMap[ch - 'a'] = true;
                replaced = replaced.replaceAll(String.valueOf(ch), "");
                break;
            }
        }

        if (containsLower(replaced)) return INVALID;
        return replaced;
    }

    private int countChar(String str, char target) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == target) count++;
        }
        return count;
    }

    private boolean containsLower(String str) {
        for (char c : str.toCharArray()) {
            if (isLower(c)) return true;
        }
        return false;
    }

    private boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }
}
