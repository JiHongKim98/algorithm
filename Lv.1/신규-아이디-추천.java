/*
 * 24/03/20
 * 
 * 프로그래머스 - 신규 아이디 추천
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 */

// 내 풀이
class Solution_Me {
    public String solution(String new_id) {
        // Step.1
        String answer = new_id.toLowerCase();
        
        // Step.2
        answer = answer.replaceAll("[^0-9a-z-_.]", "");
        
        // Step.3
        answer = answer.replaceAll("\\.{2,}", ".");
        
        // Step.4
        answer = answer.replaceAll("^\\.", "");
        answer = answer.replaceAll("\\.$", "");
        
        // Step.5
        if (answer.isEmpty()) {
            answer = "a";
        }
        
        // Step.6
        if (answer.length() >= 16) {
        	answer = answer.substring(0, 15);
        	answer = answer.replaceAll("\\.$", "");
        }
        
        // Step.7
        while (answer.length() < 3)
            answer += answer.charAt(answer.length() - 1);
        
        return answer;
    }
}

// 다른 사람 풀이
class Solution_Other {
    public String solution(String new_id) {

        String s = new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();


        return s;
    }

    private static class KAKAOID {
        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }
}
