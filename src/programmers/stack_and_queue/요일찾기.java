package programmers.stack_and_queue;

public class 요일찾기 {
    public static String solution(int a, int b) {
        String answer = "";
        int total = 0;

        String[] dayName = {"FRI","SAT","SUN","MON","TUE","WED","THU"};

        for(int i = 1; i < a; i++) {
            if(i == 4 || i == 6 || i == 9 || i == 11){
                total += 30;
            }else if (i == 2) {
                total += 29;
            }else {
                total += 31;
            }
        }
        total += b - 1;
        answer = dayName[total%7];

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }
}
