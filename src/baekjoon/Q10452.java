package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Title : 순열 사이클

풀이 전략 : 순열 사이클을 보고 DFS로 풀었다.

 */
public class Q10452 {
    static int[] arr;
    static int n;
    static boolean[] v;

    public static int dfs(int i) {
        if (i == arr[i] || v[i]) {
            return 1;
        }

        v[i] = true;
        return dfs(arr[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int tc = Integer.parseInt(br.readLine());

        int cnt;

        for (int i = 0; i < tc; i++) {
            n = Integer.parseInt(br.readLine());
            cnt = 0;
            arr = new int[n + 1];
            v = new boolean[n + 1];
            for (int j = 1; j < n + 1; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j < n + 1; j++) {
                if (!v[j]) {
                    cnt += dfs(j);
                }
            }
            System.out.print(cnt);
        }

    }
}
