package src.kakao.blind;

import java.util.*;

public class 주차요금 {

    public int[] solution(int[] fees, String[] records) {

        int 기본시간 = fees[0];
        int 기본요금 = fees[1];
        int 단위시간 = fees[2];
        int 단위요금 = fees[3];

        Map<String, Integer> 주차시각 = new TreeMap<>();
        Map<String, Integer> 누적시간 = new TreeMap<>();

        for (String s : records) {
            String[] a = s.split(":| ");

            int 시 = Integer.parseInt(a[0]), 분 = Integer.parseInt(a[1]);

            String 차번호 = a[2];

            if ("IN".equals(a[3]))
                주차시각.put(차번호, 시 * 60 + 분);
            else {
                int 시간 = (시 * 60 + 분) - 주차시각.get(차번호);
                누적시간.put(차번호, 시간 + 누적시간.getOrDefault(차번호, 0));
                주차시각.remove(차번호);
            }
        }

        for (String 차번호 : 주차시각.keySet()) {
            int 시간 = (23 * 60 + 59) - 주차시각.get(차번호);

            누적시간.put(차번호, 시간 + 누적시간.getOrDefault(차번호, 0));
        }

        List<Integer> list = new ArrayList<>();

        for (String 차번호 : 누적시간.keySet()) {
            double 시간 = Math.max(0, 누적시간.get(차번호) - 기본시간);
            int 요금 = 기본요금 + (int) Math.ceil(시간 / 단위시간) * 단위요금;

            list.add(요금);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        주차요금 instance = new 주차요금();
        int[] fees = new int[]{180, 5000, 10, 600};

        String[] records = new String[]{
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT"
        };

        System.out.println(Arrays.toString(instance.solution(fees, records)));
    }
}
