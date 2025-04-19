/*
 * 프로그래머스 - 매칭 점수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42893
 */
package Lv_3.매칭_점수;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String word, String[] pages) {
        String lowerWord = word.toLowerCase();

        List<PageInfo> pageList = new ArrayList<>();
        Map<String, PageInfo> pageMap = new HashMap<>();

        for (int i = 0; i < pages.length; i++) {
            String html = pages[i].toLowerCase();

            Matcher urlMatcher =
                    Pattern.compile("<meta property=\"og:url\" content=\"https://(.*?)\"/>").matcher(html);
            urlMatcher.find();
            String url = urlMatcher.group(1);

            Matcher linkMatcher = Pattern.compile("<a href=\"https://(.*?)\">").matcher(html);
            List<String> externalLinks = new ArrayList<>();
            while (linkMatcher.find()) {
                externalLinks.add(linkMatcher.group(1));
            }

            String body = html.replaceAll("[^a-z]", " ");
            String[] words = body.split("\\s+");
            int defaultScore = 0;
            for (String w : words) {
                if (w.equals(lowerWord)) defaultScore++;
            }

            PageInfo page = new PageInfo(i, url, defaultScore, externalLinks);

            pageList.add(page);
            pageMap.put(url, page);
        }

        for (PageInfo page : pageList) {
            double linkScore = page.defaultScore / (double) Math.max(1, page.externalLinks.size());
            for (String link : page.externalLinks) {
                if (pageMap.containsKey(link)) {
                    pageMap.get(link).linkScore += linkScore;
                }
            }
        }

        pageList.sort((o1, o2) -> {
            if (Double.compare(o2.score(), o1.score()) == 0) {
                return Integer.compare(o1.idx, o2.idx);
            }
            return Double.compare(o2.score(), o1.score());
        });

        return pageList.get(0).idx;
    }

    class PageInfo {
        int idx;
        String url;
        int defaultScore;
        List<String> externalLinks;
        double linkScore = 0;

        PageInfo(int idx, String url, int defaultScore, List<String> externalLinks) {
            this.idx = idx;
            this.url = url;
            this.defaultScore = defaultScore;
            this.externalLinks = externalLinks;
        }

        double score() {
            return defaultScore + linkScore;
        }
    }
}
