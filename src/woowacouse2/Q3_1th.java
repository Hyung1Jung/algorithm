package woowacouse2;

public class Q3_1th {

    public static void main(String[] args) {
        int[] a=  {0, 0};
        int[][] b = {{1000,0}};
        System.out.println(solution(a, b, 1000));
    }
    public static int solution(int[] restaurant, int[][] riders, int k) {
        int answer = 0;
        for(int i=0; i<riders.length; i++) {
            if(Math.pow(k, 2) >= Math.pow(restaurant[0]-riders[i][0],2)+Math.pow(restaurant[1]-riders[i][1],2)) {
                answer++;
            }
        }
        return answer;
    }
}