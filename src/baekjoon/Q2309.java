package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int input = Integer.parseInt(br.readLine());
            a[i] = input;
            sum += input;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - a[i] - a[j] == 100) {
                    a[i] = 0;
                    a[j] = 0;
                    for (int s : a) {
                        if (s != 0) {
                            System.out.println(s);
                        }

                    }
                }

            }
        }
    }
}

