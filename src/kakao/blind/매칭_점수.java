package src.kakao.blind;

import java.util.*;

public class 매칭_점수 {

    class Page {

        int index;
        int basic;
        int link;

        double score;

        Page(int index, int basic, int link, double score) {
            this.index = index;
            this.basic = basic;
            this.link = link;
            this.score = score;
        }
    }

    class Comp implements Comparator<Page> {

        @Override
        public int compare(Page a, Page b) {
            if (a.score == b.score) {
                return a.index - b.index;
            } else if (a.score < b.score) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public int solution(String word, String[] pages) {
        int wordSize = word.length();
        int answer = 0;

        Map<String, Integer> pageMap = new HashMap<>();
        List<Page> pageList = new ArrayList<>();

        word = word.toLowerCase();

        for (int i = 0; i < pages.length; ++i) {
            pages[i] = pages[i].toLowerCase();
            String s = pages[i];

            int mid = 0;

            int positionLeft = 0;
            int positionRight = 0;

            while (mid <= positionLeft) {
                positionLeft = s.indexOf("<meta", positionLeft + 1);
                positionRight = s.indexOf(">", positionLeft);
                mid = s.lastIndexOf("https://", positionRight);
            }

            positionRight = s.indexOf("\"", mid);
            String url = s.substring(mid, positionRight);

            positionLeft = s.indexOf("<body>", positionRight);

            int basicScore = 0;

            for (int start = positionRight; ; ) {

                start = s.indexOf(word, start + 1);

                if (start == -1) {
                    break;
                }

                if (!Character.isLetter(s.charAt(start - 1)) && !Character.isLetter(s.charAt(start + wordSize))) {
                    basicScore++;
                    start += wordSize;
                }
            }

            int link = 0;

            for (int start = positionLeft; ; ) {
                start = s.indexOf("<a href", start + 1);

                if (start == -1) {
                    break;
                }

                link++;
            }

            pageMap.put(url, i);
            pageList.add(new Page(i, basicScore, link, basicScore));
        }

        for (int i = 0; i < pages.length; ++i) {
            String s = pages[i];

            for (int positionLeft = 0, positionRight = 0; ; ) {
                positionLeft = s.indexOf("<a href", positionRight);

                if (positionLeft == -1) {
                    break;
                }

                positionLeft = s.indexOf("https://", positionLeft);
                positionRight = s.indexOf("\"", positionLeft);

                String linkUrl = s.substring(positionLeft, positionRight);
                Integer value = pageMap.get(linkUrl);

                if (value != null) {
                    double matchingScore = (double) pageList.get(i).basic / pageList.get(i).link;
                    pageList.get(value).score += matchingScore;
                }

            }
        }

        pageList.sort(new Comp());

        answer = pageList.get(0).index;

        return answer;
    }

    public static void main(String[] args) {
        매칭_점수 instance = new 매칭_점수();
        System.out.println(instance.solution("Muzi", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"}));
    }

}
