package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] X = new int[3], Y = new int[3];
        for (int i = 0; i < 3; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            X[i] = Integer.parseInt(tokenizer.nextToken());
            Y[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.printf("%d %d\n", X[0] ^ X[1] ^ X[2], Y[0] ^ Y[1] ^ Y[2]);
    }
}


/*
축에 평행한 직사각형 이기때문에, x좌표, y좌표가 각각 같은 점이 두 개 있을 것이다.
그래서 x좌표가 1개인 것을 4번째 점의 x좌표로 사용하고, y좌표가 1개 인 것을 4번째 점의 y좌표로 사용했다.
예제로 보면
30 20
10 10
10 20

x는 30, 10, 10
y는 20, 10, 20

x는 10이 두번 나오기에 30이 4번째점 x이고
y는 20이 두번 나오기에 10이 4번째점 y이다.

입력 받은 x 좌표들끼리 XOR 연산을 하면,
짝수번 반복된 x 좌표들은 0 이 되고, 홀수번 반복된 x 좌표 값만 남는다.
y 좌표도 마찬가지이다.
 */