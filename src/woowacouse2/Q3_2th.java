package woowacouse2;

import java.util.Arrays;

public class Q3_2th {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public int solution(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int ans = 0;
        int discountCnt = discounts.length;

        for(int i=prices.length-1; i>=0; i--) {
            ans+= discountCnt>=0 ? prices[i] * (100-discounts[discountCnt--]) / 100 : prices[i];

        }
        return ans;
    }
}