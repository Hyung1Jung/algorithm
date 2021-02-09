package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10972 {

    static int n, array[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(array));
    }
}
