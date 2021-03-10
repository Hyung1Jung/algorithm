package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Q7568 {

    static class Person{
        int weight, height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        Person[] A = new Person[N];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int w = Integer.parseInt(tokenizer.nextToken());
            int h = Integer.parseInt(tokenizer.nextToken());
            A[i] = new Person(w, h);
        }
        for (int a = 0; a < N; ++a) {
            int rank = 1;
            for (int b = 0; b < N; ++b) if (A[b].weight > A[a].weight && A[b].height > A[a].height) ++rank;
            builder.append(rank).append(' ');
        }
        System.out.println(builder.toString());
    }
}