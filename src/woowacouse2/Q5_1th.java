package woowacouse2;

/*

배달이가 좋아하는 369게임(배달이는 아재입니다.)를 하고자 합니다.
놀이법은 1부터 숫자를 하나씩 대면서, 3, 6 , 9가 들어가는 숫자는 숫자를 말하는 대신 3,6,9의 개수만큼
손뼉을 쳐야 합니다.

숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return
하도록 solution 메서드를 완성해 주세요.

제한사항
number는 1 이상 10,000 이하인 자연수입니다.

입출력 예
number   result
13          4
33          14

입출력 예 설명

입출력 예 #1
1부터 13까지 총 4번의 손뼉을 쳐야 합니다.
3   6   9  13
짝 짝  짝  짝

입출력 예 #2
1부터 33까지 총 14번의 손뼉을 쳐야 합니다.
3   6   9   13  16  19  23  26  29  30  31  32  33
짝 짝  짝  짝  짝   짝  짝  짝  짝   짝  짝   짝  짝

 */
public class Q5_1th {

    public static int solution(int number) {

        return count(number);
    }

    private static int count(int number){
        int result = 0;

        for(int i = 1; i <= number; i++) {
            String[] array = String.valueOf(i).split("");
            for(String s : array) {
                if(3 == Integer.valueOf(s) || 9 == Integer.valueOf(s) || 6 == Integer.valueOf(s)){
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(33));
    }
}

/*
방법2

public static int solution(int number) {

 static int count369(int number) {
        int count = 0;
        for (char c : String.valueOf(number).toCharArray())
            if (c == '3' || c == '6' || c == '9')
                ++count;
        return count;
    }

    public static int solution2(int number) {
        int sum = 0;
        for (int i = 1; i <= number; ++i)
            sum += count369(i);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution2(13));
        System.out.println(solution2(33));
    }
}
 */