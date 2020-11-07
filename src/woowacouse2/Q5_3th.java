package woowacouse2;

import java.util.ArrayList;
import java.util.List;

public class Q5_3th {
    public String solution(String penter, String pexit, String pescape, String data) {
        List<String> list = new ArrayList<>();

        int lPenter = penter.length();
        int lData = data.length();

        if(penter.equals(pexit) || penter.equals(pescape) || pexit.equals(pescape)) return null;
        if(!(penter.length() > 1 && penter.length() < 101)) return null;
        if(!(data.length() > 0 && data.length() < 100001 && lData%lPenter == 0)) return null;

        list.add(penter);

        for(int i = 0; i < lData/lPenter; i++) {
            if(data.substring(i * lPenter, i * lPenter + lPenter).equals(penter) ||
                    data.substring(i * lPenter, i * lPenter + lPenter).equals(pexit) ||
                    data.substring(i * lPenter, i * lPenter + lPenter).equals(pescape)) {
                list.add(pescape);
                list.add(data.substring(i * lPenter, i * lPenter + lPenter));
            } else {
                list.add(data.substring(i * lPenter, i * lPenter + lPenter));
            }
        }

        list.add(pexit);

        String answer = "";
        for (String str : list) {
            answer += str;
        }
        return answer;
    }
}