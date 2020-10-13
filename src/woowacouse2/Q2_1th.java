package woowacouse2;

import java.util.HashMap;
import java.util.Map;

public class Q2_1th {

    public static String solution(String word) {
        String result = "";

        String[] array_Word;
        String[] change_word = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M",
                "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A" };

        Map<String, String> alpha = new HashMap<>();

        char[] alpabat = new char[26];

        for (int i = 0; 1 < alpabat.length; i++) {
            alpha.put(Character.toString((char) ('A' + i)), change_word[i]);
        }

        array_Word = word.split("");

        return result;
    }

}
