package naver.b2020;

public class Exam1 {
    static String solution(String m, String k) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (char c : m.toCharArray())
            if (i >= k.length() || c != k.charAt(i)) result.append(c);
            else ++i;
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("kkaxbycyz", "abc"));
        System.out.println(solution("acbbcdc", "abc"));
    }
}
