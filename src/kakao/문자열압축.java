package kakao;

public class 문자열압축 {
    public static int solution(String s) {
        int answer = 1001;

        if(s.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= s.length() / 2; i++) {
            String now;
            String next = "";
            String result = "";
            int hit = 1;

            for (int j = 0; j <= s.length() / i; j++) {
                int start = j * i;
                int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
                now = next;
                next = s.substring(start, end);

                if(now.equals(next)) {
                    hit++;
                } else {
                    result += (processHit(hit) + now);
                    hit = 1;
                }
            }
            result += (processHit(hit) + next);
            answer = Math.min(answer, result.length());
        }

        return answer;
    }

    private static String processHit(int hit) {
        return hit > 1 ? String.valueOf(hit) : "";
    }

    public static void main(String[] args) {
        문자열압축 kakao = new 문자열압축();
        System.out.println(kakao.solution("aabbaccc"));
    }
}
