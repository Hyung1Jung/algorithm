package src.kakao.blind;

public class 숫자_문자열과_영단어 {

    String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public int solution(String s) {

        for (int i = 0; i < word.length; ++i) {
            s = s.replaceAll(word[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }


    public static void main(String[] args) {
        숫자_문자열과_영단어 instance = new 숫자_문자열과_영단어();
        System.out.println(instance.solution("one4seveneight"));
    }
}
