package src.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 이차열_배열과_연산 {

    static class Number {

        Number(int number, int count) {
            this.number = number;
            this.count = count;
        }

        int number;
        int count;
    }

    static int R;
    static int C;
    static int K;

    static int[][] Array = new int[100][100];


    static int solve() {
        int rSize = 3;
        int cSize = 3;

        for (int t = 0; t <= 100; ++t) {

            if (Array[R][C] == K) {
                return t;
            }

            if (rSize >= cSize) {
                for (int i = 0; i < rSize; ++i) {
                    List<Number> numList = new ArrayList<>();
                    int[] count = new int[101];

                    for (int j = 0; j < cSize; ++j) {
                        count[Array[i][j]]++;
                    }

                    for (int c = 1; c <= 100; ++c) {
                        if (count[c] > 0) {
                            numList.add(new Number(c, count[c]));
                        }
                    }

                    numList.sort((lhs, rhs) -> {
                        return lhs.count - rhs.count;
                    });

                    int index = 0;

                    for (Number number : numList) {
                        if (index >= 99) {
                            break;
                        }

                        Array[i][index++] = number.number;
                        Array[i][index++] = number.count;
                    }

                    cSize = Math.max(cSize, index);

                    for (; index < 100; ++index) {
                        Array[i][index] = 0;
                    }
                }
            } else {
                for (int j = 0; j < rSize; ++j) {
                    List<Number> numList = new ArrayList<>();
                    int[] count = new int[101];

                    for (int i = 0; i < cSize; ++i) {
                        count[Array[i][j]]++;
                    }

                    for (int c = 1; c <= 100; ++c) {
                        if (count[c] > 0) {
                            numList.add(new Number(c, count[c]));
                        }
                    }

                    numList.sort((lhs, rhs) -> {
                        return lhs.count - rhs.count;
                    });

                    int index = 0;

                    for (Number number : numList) {
                        if (index >= 99) {
                            break;
                        }

                        Array[index++][j] = number.number;
                        Array[index++][j] = number.count;
                    }

                    rSize = Math.max(rSize, index);

                    for (; index < 100; ++index) {
                        Array[index][j] = 0;
                    }
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt() - 1;
        C = scanner.nextInt() - 1;
        K = scanner.nextInt();

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                Array[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solve());
    }
}
