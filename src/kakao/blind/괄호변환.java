package src.kakao.blind;

import java.util.Stack;

public class 괄호변환 {
    int pos;

    boolean isCorrect(String str) {
        boolean result = true;

        int left = 0;
        int right = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                left++;
                stack.push('(');
            } else {
                right++;

                if (stack.empty()) {
                    result = false;
                } else {
                    stack.pop();
                }
            }
            if (left == right) {
                pos = i + 1;
                return result;
            }
        }

        return true;
    }

    public String solution(String p) {

        if (p.isEmpty()) {
            return p;
        }

        boolean correct = isCorrect(p);

        String u = p.substring(0, pos);
        String v = p.substring(pos);

        if (correct) {
            return u + solution(v);
        }

        StringBuilder answer = new StringBuilder("(" + solution(v) + ")");

        for (int i = 1; i < u.length() - 1; ++i) {
            if (u.charAt(i) == '(') {
                answer.append(")");
            } else {
                answer.append("(");
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        괄호변환 instance = new 괄호변환();
        System.out.println(instance.solution("()))((()"));
    }
}
