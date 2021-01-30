package programmers.sorting;

public class 가운데_글자_가져오기 {

    public static String solution(String s) {
        String answer = "";

        if(s.length()%2==0) {
            answer = s.substring(s.length()/2-1, s.length()/2+1);
        } else {
            answer = s.substring(s.length()/2,s.length()/2+1);
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "abcde";

        System.out.println(solution(s));
    }
}
