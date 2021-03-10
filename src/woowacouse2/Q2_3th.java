//package woowacouse2;
//
//public class Q2_3th {
//
//    public long[] solution(String s, String op) {
//        long[] answer = new long[s.length() - 1];
//        if (s.length() > 1 && s.length() < 11) {
//            for (int i = 0; i < s.length() - 1; i++) {
//                if (op.equals("+")) {
//                    answer[i] = Long.parseLong(s.substring(0, i + 1)) + Long.parseLong(s.substring(i + 1));
//                } else if (op.equals("-")) {
//                    answer[i] = Long.parseLong(s.substring(0, i + 1)) - Long.parseLong(s.substring(i + 1));
//                } else {
//                    answer[i] = Long.parseLong(s.substring(0, i + 1)) * Long.parseLong(s.substring(i + 1));
//                }
//            }
//        }
//        return answer;
//    }
//
//
//    public static void main(String[] args) {
//
//
//}
