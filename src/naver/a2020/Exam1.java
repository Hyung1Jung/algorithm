package naver.a2020;

public class Exam1 {
    static String solution(int n, int[] production, int[] order) {

        int price = 100;
        int stock = 0;
        int sale = 0;
        int day;

        for (day = 0; day < n && price >= 25; ++day) {
            stock += production[day];
            if (stock >= order[day]) {
                sale += order[day] * price;
                stock -= order[day];
                price = 100;
            } else price /= 2;
        }
        return String.format("%.2f", (double) sale / day);
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{5, 4, 7, 2, 0, 6}, {4, 6, 4, 9, 2, 3}};
        int[][] b = new int[][]{{6, 2, 1, 0, 2, 4, 3}, {3, 6, 6, 2, 3, 7, 6}};
        System.out.println(solution(a[0].length, a[0], a[1]));
        System.out.println(solution(b[0].length, b[0], b[1]));
    }
}