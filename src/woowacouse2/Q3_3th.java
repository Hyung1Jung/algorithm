package woowacouse2;

import java.security.spec.RSAOtherPrimeInfo;

public class Q3_3th {

    public static int solution(int money, String[] expected, String[] actual) {
        int bettingMoney = 100;
        int remainMoney = money;

        for (int i = 0; i < expected.length; i++) {
            if (remainMoney < 1000 && remainMoney > 100000 && expected.length < 1 && actual.length > 10000) {
                break;
            }

            if (expected[i].equals(actual[i])) {
                remainMoney += bettingMoney;
                bettingMoney = 100;
                continue;
            }

            remainMoney -= bettingMoney;
            if (remainMoney < bettingMoney * 2) {
                bettingMoney = remainMoney;
                continue;
            }
            bettingMoney = bettingMoney * 2;
        }
        int answer = remainMoney;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(1000, new String[] {"H","T","H","T","H","T", "H"}, new String[] {"T", "T", "H", "H", "T", "T", "H"}));
    }
}
