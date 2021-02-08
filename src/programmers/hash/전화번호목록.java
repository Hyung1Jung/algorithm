package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], phone_book[i]);
        }

        int size = map.size();
        ;
        for (int i = 0; i < size; i++) {
            String a = map.get(phone_book[i]);
            for (int j = i + 1; j < size; j++) {
                if (a.startsWith(phone_book[j]) || phone_book[j].startsWith(a)) {
                    answer = false;
                    break;
                }
            }

            if (answer == false) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"123", "456", "789"}));
    }
}