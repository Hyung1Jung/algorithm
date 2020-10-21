package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1476 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt(), s = sc.nextInt(), m = sc.nextInt();

        int year = 0;
        while(true) {
            year++;
            if( (year-e)%15 == 0 && (year-s)%28 == 0 && (year-m)%19 == 0) {
                break;
            }
        }
        System.out.println(year);


    }
}
