package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1978 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        //BufferedReader br = new BufferedReader( new FileReader("input.txt" ) );
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int temp = 0;
        int cnt=0;
        st = new StringTokenizer(br.readLine());

        loop1: while(st.hasMoreTokens()==true) {
            temp = Integer.parseInt(st.nextToken());
            if(temp==1 || temp==0)
                continue loop1;
            for(int i=2;i*i<=temp;i++) { // N^1/2 까지만 계산
                if(temp%i==0)
                    continue loop1;
            }
            cnt++;
        }

        System.out.println(cnt);


    }

}