package src.kakao.blind;

import java.util.*;

public class 신고결과받기 {
    class Report {
        Set<String> reportSet = new HashSet<>();
        Set<String> reportedSet = new HashSet<>();
    }

    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Report> map = new HashMap<>();

        for (String id : id_list)
            map.put(id, new Report());

        for (String r : report) {
            String[] a = r.split(" ");
            map.get(a[0]).reportSet.add(a[1]);
            map.get(a[1]).reportedSet.add(a[0]);
        }

        List<Integer> answer = new ArrayList<>();

        for (String id : id_list) {
            int count = 0;

            for (String user : map.get(id).reportSet) {
                if (map.get(user).reportedSet.size() >= k)
                    ++count;
            }

            answer.add(count);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        신고결과받기 instance = new 신고결과받기();

        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(instance.solution(id_list, report, k)));
    }
}

