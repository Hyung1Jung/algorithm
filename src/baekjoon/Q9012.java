package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9012 {
    static boolean VPS(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') ++count;
            else if (c == ')') --count;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            String s = reader.readLine();
            builder.append(VPS(s) ? "YES" : "NO").append('\n');
        }
        System.out.println(builder.toString());
    }
}

/*
Q9012, 괄호

여는 괄호와 닫는 괄호의 수가 일치하지 않으면 VPS가 아니다.
여는 괄호가 먼저 나와야 한다. 닫는 괄호가 먼저 나오면 VPS가 아니다.
count값이 0이면, 여는 괄호, 닫는 괄호가 일치하지 않은 것이다.
중간에 count 값이 음수가 되면, 여는 괄호보다 닫는 괄호가 먼저 나온 것이다.
*/