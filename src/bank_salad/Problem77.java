package bank_salad;

import java.util.*;

public class Problem77 {

    private static int[][] solution(int[][] array) {

        List<Integer> list = new LinkedList<>();

        int[][] createList = createList(array, list);
        int[][] result = listToArray(createList, list);

        return result;

    }

    // 중첩되는 인터벌들을 하나로 합친 리스트
    private static int[][] createList(int[][] array, List<Integer> list) {

        int count = 0;
        int length = array.length;

        for (int i = 1; i < length; i++) {

            if (array[i - 1][1] < array[i][0] || i == length - 1) {
                list.add(array[i - 1][0]);
                list.add(array[i - 1][1]);
                list.add(array[length - 1][0]);
                list.add(array[length - 1][1]);
            }

            count = i;
        }

        return new int[count][2];
    }

    // 리스트를 다시 2차원 배열로 변환
    private static int[][] listToArray(int[][] createList, List<Integer> list) {

        int getListIndex = 0;
        int length = createList.length;

        for (int i = 0; i < length; i++) {

            createList[i][0] = list.get(getListIndex);
            getListIndex++;

            createList[i][1] = list.get(getListIndex);
            getListIndex++;

        }

        return createList;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 3}, {5, 8}, {4, 10}, {20, 25}};
        System.out.println((Arrays.deepToString(solution(array))));
    }

}