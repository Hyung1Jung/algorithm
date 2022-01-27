package src.kakao.blind;

import java.util.*;

public class 메뉴리뉴얼 {

    List<Map<String, Integer>> foodMaps = new ArrayList();
    int[] MaxCnt = new int[11];

    void comb(char[] str, int pos, StringBuilder candi) {

        if (pos >= str.length) {
            int len = candi.length();

            if (len >= 2) {
                int cnt = foodMaps.get(len).getOrDefault(candi.toString(), 0) + 1;
                foodMaps.get(len).put(candi.toString(), cnt);
                MaxCnt[len] = Math.max(MaxCnt[len], cnt);
            }
            return;
        }

        comb(str, pos + 1, candi.append(str[pos]));
        candi.setLength(candi.length() - 1);
        comb(str, pos + 1, candi);
    }

    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < 11; ++i) {
            foodMaps.add(new HashMap<>());
        }

        for (String str : orders) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            comb(arr, 0, new StringBuilder());
        }

        List<String> list = new ArrayList<>();

        for (int len : course) {
            for (Map.Entry<String, Integer> entry : foodMaps.get(len).entrySet()) {
                if (entry.getValue() >= 2 && entry.getValue() == MaxCnt[len]) {
                    list.add(String.valueOf(entry.getKey()));
                }
            }
        }

        Collections.sort(list);

        String[] answer = new String[list.size()];

        int size = list.size();

        for (int i = 0; i < size; ++i) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        메뉴리뉴얼 instance = new 메뉴리뉴얼();
        System.out.println(Arrays.toString(instance.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
    }
}
