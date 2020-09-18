package woowacouse2;

import java.util.Set;
import java.util.TreeSet;

public class Q6 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public String[] solution(String[][] forms) {
        Set<String> emailSet = new TreeSet<>();
        for(int i=0; i<forms.length; i++) {
            for(int j=i+1; j<forms.length; j++) {
                char[] p1 = forms[i][1].toCharArray();
                char[] p2 = forms[j][1].toCharArray();
                if(isSimilar(p1, p2)) {
                    emailSet.add(forms[i][0]);
                    emailSet.add(forms[j][0]);
                }
            }
        }
        String[] answer =emailSet.toArray(new String[emailSet.size()]);
        return answer;
    }

    public static boolean isSimilar(char[] p1, char[] p2) {
        int[][] lcs = new int[p1.length+1][p2.length+1];
        for(int i=1; i<=p1.length; i++) {
            for(int j=1; j<=p2.length; j++) {
                if(p1[i-1] == p2[j-1]) {
                    lcs[i][j] = lcs[i-1][j-1]+1;
                    if(lcs[i][j] >= 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}