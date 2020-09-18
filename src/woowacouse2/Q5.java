package woowacouse2;

import java.util.Arrays;

public class Q5 {

    public static void main(String[] args) {
        String[] a = {"1.0", "2.0", "0.0", "1.0"};
        int [] ans = solution(a);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solution(String[] history) {
        int[] refri = {5, 100, 10, 5, 2};
        int[] market = {10, 100, 30, 50, 10};
        int[] price = {10000, 3000, 1000, 2000, 1000};
        int[] recipe = {4, 50, 10, 10, 4};
        int[] answer = new int[history.length];

        for(int i=0; i<history.length; i++) {
            double p = Double.parseDouble(history[i]);
            if(p < 1.0 || p > 2.5 || p%0.5 != 0) {
                int[] ans = {-1};
                return ans;
            }

            boolean isLover = (p%1.0)==0.5 ? true : false;
            int sum = 0;

            for(int j=0; j<refri.length; j++) {
                if(isLover && j==4) {
                    refri[j] -= recipe[j]*p/2;
                } else {
                    refri[j] -= recipe[j]*p;
                }
            }
            for(int j=0; j<refri.length; j++) {
                if(refri[j]<0) {
                    while(refri[j] < 0) {
                        refri[j]+=market[j];
                        sum += price[j];
                    }
                }
            }
            answer[i] = sum;
        }
        return answer;
    }

}