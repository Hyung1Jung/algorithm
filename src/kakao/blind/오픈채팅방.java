package src.kakao.blind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 오픈채팅방 {

    public String[] solution(String[] record) {
        Map<String, String> hashMap = new HashMap<>();

        int cnt = 0;

        for (String str : record) {

            StringTokenizer tokenizer = new StringTokenizer(str);
            String cmd = tokenizer.nextToken();

            if (cmd.equals("Enter") || cmd.equals("Leave")) {
                ++cnt;
            }

            if (cmd.equals("Enter") || cmd.equals("Change")) {
                String id = tokenizer.nextToken();
                String name = tokenizer.nextToken();

                hashMap.put(id, name);
            }
        }

        String[] answer = new String[cnt];

        int idx = 0;

        for (String str : record) {

            StringTokenizer tokenizer = new StringTokenizer(str);
            String cmd = tokenizer.nextToken();

            if (cmd.equals("Enter")) {
                String id = tokenizer.nextToken();
                answer[idx++] = hashMap.get(id) + "님이 들어왔습니다.";
            } else if (cmd.equals("Leave")) {
                String id = tokenizer.nextToken();
                answer[idx++] = hashMap.get(id) + "님이 나갔습니다.";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        오픈채팅방 instance = new 오픈채팅방();
        System.out.println(Arrays.toString(instance.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" })));
    }
}
