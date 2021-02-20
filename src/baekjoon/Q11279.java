package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(reader.readLine());
            if(k==0) {
                if(q.isEmpty()) {
                    sb.append(0+"\n");
                } else {
                    //출력할 땐 다시 -1을 곱해서 양수로
                    sb.append(q.poll()*-1+"\n");
                }
            } else {
                //최댓값을 삭제해야 하므로 삽입 시 -1을 곱해준다.
                q.add(k*-1);
            }
        }
        System.out.print(sb.toString());
    }
}
