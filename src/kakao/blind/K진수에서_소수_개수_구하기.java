package src.kakao.blind;

import java.util.Arrays;

public class K진수에서_소수_개수_구하기 {

    public int solution(int n, int k) {
        int answer = -1;

        String[] array = change(n, k);

        int size = array.length;
        int count = 0;

        for (int i = 0; i < size; ++i) {
            if (isPrime(Long.parseLong(array[i]))) {
                count++;
            }
        }

        answer = count;

        return answer;
    }

    String[] change(int n, int k) {
        String s = Integer.toString(n, k);

        return s.split("0+");
    }

    // int 범위를 초과하기 때문에 long로
    boolean isPrime(long num) {

        if (num == 1) {
            return false;
        }

        double limit = Math.sqrt(num); // 아래 설명 글 참조

        for (int i = 2; i <= limit; ++i) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        K진수에서_소수_개수_구하기 instance = new K진수에서_소수_개수_구하기();
        System.out.println(instance.solution(437674, 3));
    }
}

/*

Math.sqrt(num) 관련..

소수 (prime number)
소수는 1과 자가 자신을 제외한 다른 수로 나누어 떨어지지 않는 수이다.

1은 소수가 아니고, 2는 소수이다.
2, 3, 5, 7, 11, 13, 17...

36의 인수는 다음과 같다
2, 3, 4, 6, 9, 12, 18

2 * 18 = 36
3 * 12 = 36
4 * 9 = 36
6 * 6 = 36
9 * 4 = 36
12 * 3 = 36
18 * 2 = 36

위 곱셈들을 살펴 보면, 6 * 6 = 36을 기준으로 상하 대칭이다.
36의 인수들은 36의 제곱근인 6을 기준으로 위 아래 쌍을 이룬다. (2, 18) (3, 12) (4, 9)

따라서 36의 인수를 찾을 때,
 2부터 그 제곱근인 6까지 2, 3, 4, 5, 6 각각으로 36을 나누어 봐서
 2로 나누어 떨어진다면 2는 36의 인수이고,
 2가 36의 인수라면 36 / 2 = 18도 36의 인수이다.

같은 원리로, 소수인지 아닌지 판단할 때도, 2부터 그 수의 제곱근까지 범위의 정수들로만 나누어 보면 된다.
*/

/*

    방법 2

    static class Solution {
        String K진수(int value, int k) {
            var builder = new StringBuilder();
            while (value > 0) {
                builder.append((char) ('0' + (value % k)));
                value = value / k;
            }
            return builder.reverse().toString();
        }

        boolean 소수인가(int n) {
            if (n == 1) return false;
            double limit = Math.sqrt(n);
            for (int i = 2; i <= limit; ++i)
                if (n % i == 0) return false;
            return true;
        }

        public int solution(int value, int k) {
            int answer = 0;
            String s = K진수(value, k);
            String[] a = s.split("0+");
            for (String t : a) {
                int i = Integer.valueOf(t);
                if (소수인가(i)) ++answer;
            }
            return answer;
        }

 */

