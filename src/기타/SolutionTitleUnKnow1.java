package src.기타;

/*
EX) N이 주어졌을때, N의 자릿수의 합을 구한다.
그리고 N보다 크고 50000이하의 수들 중에서, 각 자릿수의 합이 N의 자릿수의 합과 일치하는 수 중에 최소 값을 구해라

Ex)
28의 각 자릿수 합은 (2 + 8) 10이다.
28보다 크고 50000보다 작은 수 들중에서 자릿수 합이 10인 최소 수는

29(2+9)/ 11
30 / 3
31 / 4
32 / 5
33 / 6
34 / 7
35 / 8
36 / 9
37 / 10

따라서 답은 10이다.

 */

public class SolutionTitleUnKnow1 {

    int solution(int N) {

        if (N < 10) {
            return N;
        }

        int answer = 0;

        for (int i = N + 1; i < 50000; ++i) {
            if (getSum(i) == getSum(N)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    int getSum(int N) {
        int sum = 0;

        while (N != 0) {
            sum = sum + N % 10;
            N = N / 10;
        }

        return sum;
    }


    public static void main(String[] args) {
        int N = 28;
        SolutionTitleUnKnow1 solution = new SolutionTitleUnKnow1();
        System.out.println(solution.solution(N));
    }
}

