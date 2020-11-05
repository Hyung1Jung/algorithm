package woowacouse2;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었습니다.
예를 들어 browoanoommnaon이라는 암호문은 다음과 같은 순서로 해독할 수 있습니다.

1. "browoanoommnaon"
2. "browoannaon"
3. "browoaaon"
4. "browoon"
5. "brown"
임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성해주세요.

# 제한사항
cryptogram은 길이가 1 이상 1000 이하인 문자열입니다.
cryptogram은 알파벳 소문자로만 이루어져 있습니다.

# 입출력 예
cryptogram      result
browoanoommnaon brown
zyelleyz        ""

# 입출력 예 설명
입출력 예 #1
문제의 예시와 같습니다.

입출력 예 #2
다음과 같은 순서로 해독할 수 있습니다.

1. "zyelleyz"
2. "zyeeyz"
3. "zyyz"
4. "zz"
5. ""


 */
public class Q7_1th {

    public static String solution(String cryptogram){

        return decode(cryptogram);
    }

    private static  String decode(String str) {
        String result = "";

        boolean check = true;

        String[] array = str.split("");

        List<String> list = Arrays.asList(array);

        while(check) {
            check = false;
            List<String> reduceList = new ArrayList<>();
            reduceList.addAll(list);

            for (int i = 0; i < list.size() - 1; i++) {
                if(list.get(i).equals(list.get(i + 1))){
                    reduceList.remove(i + 1);
                    reduceList.remove(i);
                    list = reduceList;
                    check = true;
                    continue;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s);
        }
        result = sb.toString();

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("zyelleyz"));
    }
}
