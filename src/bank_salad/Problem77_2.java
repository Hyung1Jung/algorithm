package bank_salad;

import java.util.Arrays;

public class Problem77_2 {

    private static int[][] solution(int[][] array) {
        int length = array.length;
        int index = 0;
        int count = 0;
        int answer[][];

        for (int i = 1; i < length; i++) {
            if (array[i - 1][1] > array[i][0]) {
                index = i;
                count++;
            }
        }

        answer = new int[length - count][2];

        for (int i = 0; i < answer.length; i++) {
            answer[i][0] = array[i][0];
            answer[i][1] = array[i][1];

            if (i == index) {
                answer[i][0] = array[index + 1][0];
                answer[i][1] = array[index + 1][1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 3}, {4, 10}, {5, 8}, {20, 25}};
        System.out.println((Arrays.deepToString(solution(array))));
    }
}
