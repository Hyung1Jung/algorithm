package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1182 {
    static int N, S;
    static int[] A;

    static int 경우의수(int index, int count, int sum) {
        if (index == A.length) return (sum == S && count > 0) ? 1 : 0;
        int r1 = 경우의수(index + 1, count, sum);
        int r2 = 경우의수(index + 1, count + 1, sum + A[index]);
        return r1 + r2;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());
        A = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i) A[i] = Integer.parseInt(tokenizer.nextToken());
    }
}
/*
    static int 경우의수(int index, int count, int sum) {
        index는 지금 골라야할 값의 위치
        count는 지금까지 고른 값의 갯수
        sum은 지금까지 고른 값의 합계

        if (index == A.length)재귀호출의 끝에 도달했으면, 부분수열을 하나 조합한 것이다.
            return (sum == S && count > 0) ? 1 : 0;
                부분수열의 합이 S와 일치하면 1 을 리턴하고, 아니면 0 을 리턴한다.
                count 가 0 이면, 아무것도 고르지 않은 것이니, 부분 수열이 아니다. 0 을 리턴한다.

        int r1 = 경우의수(index + 1, count, sum);
        배열에서 현재 위치(index) 의 값을 고르지 않고, 다음 단계 재귀호출
        현재 위치의 값을 고르지 않았으니, 고른 값의 갯수 (count) 와 합계(sum) 에 변함이 없다.
        이렇게 재귀호출된 메소드가 리턴하는 값은, 현재 위치의 값을 고르지 않았을 때,
        합계가 S인 부분 수열의 갯수이다.

        int r2 = 경우의수(index + 1, count + 1, sum + A[index]);
        배열에서 현재 위치(index) 의 값을 고르고, 다음 단계 재귀호출
        현재 위치의 값을 골랐으니, 고른 값의 갯수 (count) 1 증가,
        현재 위치의 값 만큼 합계 (sum) 증가.
        이렇게 재귀호출된 메소드가 리턴하는 값은, 현재 위치의 값을 골랐을 때,
        합계가 S인 부분 수열의 갯수이다.

        return r1 + r2;
        합계가 S인 부분 수열의 갯수를 리턴한다.
        }
*/