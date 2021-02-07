package programmers.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class 같은숫자는싫어 {
    public static int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int num = 10;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] != num) {
                list.add(arr[i]);
                num = arr[i];
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 13, 3, 0, 1, 1};
        System.out.println(Arrays.toString(solution(arr)));
    }
}