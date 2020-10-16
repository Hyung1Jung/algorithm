package woowacouse2;

public class Q4_1th {

    public int solution(int[] pobi, int[] crong) {

        boolean page = validation(pobi, crong); // 책 예외상황 체크
        if (!page) {
            return -1;
        }

        // 포비 점수 내기
        int pobi_sum_score = sum(pobi);
        int pobi_mul_score = mul(pobi);

        int pobi_max_score = maxScore(pobi_sum_score, pobi_mul_score);

        int crong_sum_score = sum(crong);
        int crong_mul_score = sum(crong);

        int crong_max_score = maxScore(crong_mul_score, crong_sum_score);

        if (pobi_max_score > crong_max_score) {
            return 1;
        } else if (pobi_max_score < crong_max_score) {
            return 2;
        } else if (pobi_max_score == crong_max_score) {
            return 0;
        } else {
            return -1;
        }
    }

        // 점수합산 // @param value 배열
        static private int sum ( int[] value){

            int val_1 = 0;
            int val_2 = 0;

            String[] array1 = String.valueOf(value[0]).split("");
            for (String val : array1) {
                val_1 = val_1 + Integer.valueOf(val);
            }

            String[] array2 = String.valueOf(value[1]).split("");
            for (String val : array2) {
                val_2 = val_2 + Integer.valueOf(val);
            }

            return maxScore(val_1, val_2);
        }

        // 곱하기 // @param value 배열
        static private int mul ( int value[]){

            int val_1 = 1;
            int val_2 = 1;

            String[] array1 = String.valueOf(value[0]).split("");
            for (String val : array1) {
                val_1 = val_1 * Integer.valueOf(val);
            }

            String[] array2 = String.valueOf(value[1]).split("");
            for (String val : array2) {
                val_2 = val_2 * Integer.valueOf(val);
            }

            return maxScore(val_1, val_2);
        }

        // 최고점수 출력
        static private int maxScore ( int a, int b){
            if (a > b) {
                return a;
            } else {
                return b;
            }
        }
        // 예외상황 체크
        static private boolean validation ( int[] pobi, int[] crong){

            boolean result = true;

            if (1 != Math.abs(pobi[0] - pobi[1])) {
                return false;
            } else if (1 != Math.abs(crong[0] - crong[1])) {
                return false;
            } else {
                return result;
            }
    }

}
