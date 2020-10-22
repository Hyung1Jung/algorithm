package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9095 {
    static int dp[] = new int[11];
    static int array[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        array = new int[t];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= 10; i ++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            array[i] = dp[n];
        }
        for(int n : array){
            System.out.println(n);
        }

    }
}
