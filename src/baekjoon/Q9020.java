package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9020 {
    public static int MAX = 10000;
    public static boolean[] isnt_prime_num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isnt_prime_num = new boolean[MAX + 1];
        getPrimeNum();
        int size = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < size; t++) {
            int N = Integer.parseInt(br.readLine());

            for (int i = N / 2; i > 0; i--) {
                int idx1 = i;
                int idx2 = N - i;
                if (!isnt_prime_num[idx1] && !isnt_prime_num[idx2]) {
                    sb.append(idx1 + " " + idx2 + "\n");
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void getPrimeNum() {
        isnt_prime_num[1] = true;

        for (int i = 2; i <= MAX; i++) {
            for (int j = 2; i * j <= MAX; j++) {
                isnt_prime_num[i * j] = true;
            }
        }
    }
}


