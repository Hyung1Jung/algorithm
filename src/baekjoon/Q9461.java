package baekjoon;

// https://www.acmicpc.net/problem/9461

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9461 {
    static long 파도반수열(int N) {
        long[] A = new long[Math.max(N, 5)];
        A[0] = 1;
        A[1] = 1;
        A[2] = 1;
        A[3] = 2;
        A[4] = 2;
        for (int i = 5; i < N; ++i) A[i] = A[i - 1] + A[i - 5];
        return A[N - 1];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(reader.readLine());
            builder.append(파도반수열(N)).append('\n');
        }
        System.out.println(builder.toString());
    }
}
