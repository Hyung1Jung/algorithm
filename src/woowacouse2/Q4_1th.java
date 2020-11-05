package woowacouse2;

public class Q4_1th {

    public static int solution(int[] pobi, int[] crong) {

        // 페이지 예외상황 체크
        boolean page = validation(pobi, crong);
                if(!page) {
                    return -1;
                }

        // 포비 점수
        int pobi_sum_score = sum(pobi);
        int pobi_mul_score = mul(pobi);

        int pobi_max_score = maxScore(pobi_mul_score, pobi_sum_score);

        int crong_sum_score = sum(crong);
        int crong_mul_score = mul(crong);

        int crong_max_score = maxScore(crong_mul_score, crong_sum_score);

        // 점수 비교
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


    // 예외 상황 체크
    static private boolean validation(int[] pobi, int[] crong) {

        if (1 != Math.abs(pobi[1] - pobi[0])) {
            return false;
        } else if (1 != Math.abs(crong[1] - crong[0])) {
            return false;
        } else return true;
    }

    // 점수 합산
    static private int sum( int[] value){

        int value1 = 0;
        int value2 = 0;

        String[] leftArray = String.valueOf(value[0]).split("");
        for (String num : leftArray) {
            value1 += Integer.valueOf(num);
        }

        String[] rightArray = String.valueOf(value[1]).split("");
        for (String num : rightArray) {
            value2 += Integer.valueOf(num);
        }

        return maxScore(value1, value2);
    }

    // 점수 곱
    static private int mul ( int[] value){

        int value1 = 1;
        int value2 = 1;

        String[] leftArray = String.valueOf(value[0]).split("");
        for (String num : leftArray) {
            value1 *= Integer.valueOf(num);
        }

        String[] rightArray = String.valueOf(value[1]).split("");
        for (String num : rightArray) {
            value2 *= Integer.valueOf(num);
        }

        return maxScore(value1, value2);
    }

    // 최고점수 출력
    static private int maxScore ( int value1, int value2){
        if (value1 > value2) {
            return value1;
        } else {
            return value2;
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {35,37};
        int[] arr2 = {56,57};
        System.out.println(solution(arr1,arr2));
    }

}