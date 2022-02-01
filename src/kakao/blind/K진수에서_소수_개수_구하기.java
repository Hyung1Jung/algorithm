package src.kakao.blind;

import java.util.Arrays;

public class K진수에서_소수_개수_구하기 {

    public int solution(int n, int k) {
        int answer = -1;

        String[] array = change(n, k);

        int size = array.length;
        int count = 0;

        for (int i = 0; i < size; ++i) {
            if (isPrime(Integer.parseInt(array[i]))) {
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

    boolean isPrime(int num) {

        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; ++i) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        K진수에서_소수_개수_구하기 instance = new K진수에서_소수_개수_구하기();
        System.out.println(instance.solution(437674, 3));
    }
}
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

