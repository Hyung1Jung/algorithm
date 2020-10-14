package 기타;

import java.util.Arrays;

public class Exercise1 {

    //아스키코드만 확인한다고 하였을때
    public boolean checkForRepeatedCharacter(String string) {
        boolean[] arrayForCharacter = new boolean[126];

        for (int index = 0; index < string.length(); index++) {
            int character = string.charAt(index);

            if (arrayForCharacter[character]) {
                return true;
            }

            arrayForCharacter[character] = true;
        }

        return false;
    }
}