package woowacouse2;

public class Q1_3th {
    public static int solution(String[] grades, int[] weights, int threshold) {
        int answer = -1234567890;
        int totalScore = 0;

        String[] array = {"A+", "A0", "B+", "B0","C+","C0", "D+", "D0", "F"};
        int[] gradesWeights = {10, 9, 8, 7, 6, 5, 4, 3, 0};

        if(grades.length >= 1 && grades.length <= 1000 && threshold >= 1 && threshold <= 20000000) {
            for (int i = 0; i < grades.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (grades[i].equals(array[j]) && weights[i] >= 1 && weights[i] <= 1000) {
                        totalScore += gradesWeights[j] * weights[i];
                    }
                }
            }
        }
        answer = totalScore - threshold;
        return answer;
    }

    public static void main(String[] args) {
        String[] grades = {"A+", "D+", "F", "C0"};
        String[] grades2 = {"B+", "A0", "C+"};
        int[] weights = {2, 5, 10, 3};
        int[] weights2 = {6, 7, 8};
        System.out.println(solution(grades, weights, 50));
        System.out.println(solution(grades2, weights2, 200));

    }
}
