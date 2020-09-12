package kakao;

import java.util.Scanner;

public class PrizeHunter {
    public static void main(String[] args) {

        System.out.println("정형일");

        Scanner sc = new Scanner(System.in);

        int Line = sc.nextInt();

        if (Line >= 1 && Line <= 1000) {
            int[][] rank = new int[Line][2];
            int[] money = new int[Line];

            for (int i = 0; i < Line; i++) {
                for (int j = 0; j < 2; j++) {
                    rank[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < Line; i++) {
                if (rank[i][0] > 0) {
                    if (rank[i][0] == 1) {
                        money[i] += 500;
                    } else if (rank[i][0] <= 3) {
                        money[i] += 300;
                    } else if (rank[i][0] <= 6) {
                        money[i] += 200;
                    } else if (rank[i][0] <= 10) {
                        money[i] += 50;
                    } else if (rank[i][0] <= 15) {
                        money[i] += 30;
                    } else if (rank[i][0] <= 21) {
                        money[i] += 10;
                    }
                }
            }

            for (int i = 0; i < Line; i++) {
                if (rank[i][1] > 0) {
                    if (rank[i][1] == 1) {
                        money[i] += 512;
                    } else if (rank[i][1] <= 3) {
                        money[i] += 256;
                    } else if (rank[i][1] <= 7) {
                        money[i] += 128;
                    } else if (rank[i][1] <= 15) {
                        money[i] += 64;
                    } else if (rank[i][1] <= 31) {
                        money[i] += 32;
                    }
                }
            }

            for (int i = 0; i < Line; i++) {
                System.out.println(money[i] * 10000);
            }
        }
    }
}
