package woowacouse2;
/*
문제 설명


어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있엇습니다.
청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였습니다.

엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return하도록
solution 메서드를 완성해주세요.

A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
Z Y X W V U T S R Q P O N M L K J I H G F E D C B A


제한사항
word는 길이가 1 이상 1,00이상 이하인 문자열입니다.
알파벳 외의 문자는 변환하지 않습니다.
알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환합니다.


입출력 예
word result
I love you R olev blf


입출력 예 설명
입출력 예 #1

'I'는 알파벳 대문자이므로 'R'로 변환 할 수 있습니다.
공백(스페이스바)은 알파벳 외의 문자이므로 변환하지 않습니다.
'l'은 알파벳 소문자이므로 'o'로 변환할 수 있습니다.
'o'은 알파벳 소문자이므로 'l'로 변환할 수 있습니다.
'v'은 알파벳 소문자이므로 'e'로 변환할 수 있습니다.
'e'은 알파벳 소문자이므로 'v'로 변환할 수 있습니다.
공백(스페이스바)은 알파벳 외의 문자이므로 변환하지 않습니다.
'y'은 알파벳 소문자이므로 'b'로 변환할 수 있습니다.
'o'은 알파벳 소문자이므로 'l'로 변환할 수 있습니다.
'u'은 알파벳 소문자이므로 'f'로 변환할 수 있습니다.


 */

import java.util.HashMap;
import java.util.Map;

public class Q3_1th {

    public static String solution(String word) {
        String result = "";

        String[] array_Word;
        String[] change_word = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M",
                "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < change_word.length; i++) {
            map.put(Character.toString(('A' + i)), change_word[i]);
        }

        array_Word = word.split("");

        for (String c_word : array_Word) {
            boolean b = Character.isUpperCase(c_word.charAt(0));

            String temp_result = map.get(c_word.toUpperCase());

            if (temp_result == null) {
                temp_result = " ";
            } else if (!b) {
                temp_result = temp_result.toLowerCase();
            }

            result = result.concat(temp_result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }

}