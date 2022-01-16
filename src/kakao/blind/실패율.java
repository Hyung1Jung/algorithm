package src.kakao.blind;

import java.util.*;

public class 실패율 {


    class Fail {
        int stages;
        double rate;

        Fail(int stages, double rate) {
            this.stages = stages;
            this.rate = rate;
        }
    }

    Comparator<Fail> comparator = new Comparator<Fail>() {
        public int compare(Fail a, Fail b) {
            if (a.rate < b.rate) {
                return 1;
            } else if (a.rate > b.rate) {
                return -1;
            } else {
                return Integer.compare(a.stages, b.stages);
            }
        }
    };

    /*
        Comparator<Fail> comparator = new Comparator<Fail>() {
        public int compare(Fail a, Fail b) {
            if (a.rate < b.rate) {
                return 1;
            } else if (a.rate > b.rate) {
                return -1;
            } else {
                if (a.stages > b.stages) {
                    return 1;
                } else if (a.stages < b.stages) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    };
     */

    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        int total = stages.length;
        List<Fail> fails = new ArrayList<>();
        int[] users = new int[N + 1];

        for (int s : stages) {
            users[s - 1]++;
        }

        for (int i = 0; i < N; ++i) {

            if (users[i] == 0) {
                fails.add(new Fail(i + 1, 0));
            } else {
                fails.add(new Fail(i + 1, (double) users[i] / total));
                total -= users[i];
            }
        }

        fails.sort(comparator);

        for (int i = 0; i < N; ++i) {
            answer[i] = fails.get(i).stages;
        }

        return answer;
    }

    public static void main(String[] args) {
        실패율 instacne = new 실패율();
        System.out.println(Arrays.toString(instacne.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }
}
