package programmers.stack_and_queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프린터 {

    public static int solution(int[] priorities, int location) {
        int answer = 1;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i : priorities) {
            pq.add(i);
            System.out.println(pq);
        }

        while (!pq.isEmpty()) {
            int size = priorities.length;
            for (int i = 0; i < size; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
            return answer;
        }

        public static void main (String[]args){

            int[] priorities = {2, 1, 3, 2};
            int location = 1;
            int answer = solution(priorities, location);
            System.out.println(answer);

        }
    }
