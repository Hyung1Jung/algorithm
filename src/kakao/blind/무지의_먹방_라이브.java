package src.kakao.blind;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 무지의_먹방_라이브 {

    class Food {
        int time;
        int index;

        Food(int t, int i) {
            time = t;
            index = i;
        }
    }

    Comparator<Food> CompTime = new Comparator<>() {

        public int compare(Food a, Food b) {
            return a.time - b.time;
        }
    };

    Comparator<Food> CompIdx = new Comparator<Food>() {

        public int compare(Food a, Food b) {
            return a.index - b.index;
        }
    };

    public int solution(int[] food_times, long k) {

        int answer = 0;
        List<Food> foods = new LinkedList<>();
        int n = food_times.length;

        for (int i = 0; i < n; ++i) {
            foods.add(new Food(food_times[i], i + 1));
        }

        foods.sort(CompTime);

        int preTime = 0;
        int i = 0;

        for (Food f : foods) {
            long diff = f.time - preTime;

            if (diff != 0) {
                long spend = diff * n;

                if (spend <= k) {
                    k -= spend;
                    preTime = f.time;
                } else {
                    k %= n;
                    foods.subList(i, food_times.length).sort(CompIdx);

                    return foods.get(i + (int) k).index;
                }
            }

            ++i;
            --n;
        }

        return answer;
    }

    public static void main(String[] args) {
        무지의_먹방_라이브 instance = new 무지의_먹방_라이브();
        System.out.println(instance.solution(new int[]{3, 1, 2}, 5));
    }
}
