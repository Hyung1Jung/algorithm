package src.kakao.blind;

import java.util.Arrays;

public class 프렌즈4블록 {

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];
        char[][] tempMap;
        char[][] checkMap = new char[m][n];

        boolean check;

        for (int i = 0; i < m; ++i) {
            map[i] = board[i].toCharArray();
        }

        do {
            check = false;
            tempMap = deepCopy(map);

            for (int i = 0; i < m - 1; ++i) {
                for (int j = 0; j < n - 1; ++j) {
                    char value = map[i][j];

                    if ((map[i][j + 1] == value) && (map[i + 1][j] == value) && (map[i + 1][j + 1] == value)) {
                        map[i][j] = ' ';
                        map[i][j + 1] = ' ';
                        map[i + 1][j] = ' ';
                        map[i + 1][j + 1] = ' ';

                        checkMap[i][j] = value;
                        checkMap[i][j + 1] = value;
                        checkMap[i + 1][j] = value;
                        checkMap[i + 1][j + 1] = value;

                    }

                    if (value == ' ') {
                        if ((map[i][j + 1] == ' ' || map[i][j + 1] == checkMap[i][j]) && (map[i + 1][j] == ' ' || map[i + 1][j] == checkMap[i][j]) && (map[i + 1][j + 1] == ' ' || map[i + 1][j + 1] == checkMap[i][j])) {
                            map[i][j + 1] = ' ';
                            map[i + 1][j] = ' ';
                            map[i + 1][j + 1] = ' ';

                            checkMap[i][j] = checkMap[i][j];
                            checkMap[i][j + 1] = checkMap[i][j];
                            checkMap[i + 1][j] = checkMap[i][j];
                            checkMap[i + 1][j + 1] = checkMap[i][j];
                        }
                    }
                }
            }

            answer = 0;

            for (int i = 1; i < m; ++i) {
                for (int j = 0; j < n; ++j) {

                    if (map[i][j] == ' ') {
                        map[i][j] = map[i - 1][j];
                        map[i - 1][j] = ' ';
                    }

                    if (map[i - 1][j] == ' ') answer++;
                    if (i == m - 1 && map[i][j] == ' ') answer++;

                }
            }

            if (!Arrays.deepEquals(tempMap, map)) check = true;

        } while (check);

        return answer;
    }

    char[][] deepCopy(char[][] original2) {
        if (original2 == null) return null;
        char[][] result = new char[original2.length][original2[0].length];

        for (int i = 0; i < original2.length; i++) {
            System.arraycopy(original2[i], 0, result[i], 0, original2[0].length);
        }

        return result;
    }

    public static void main(String[] args) {
        프렌즈4블록 solution = new 프렌즈4블록();
        int m = 4;
        int n = 5;
        String[] board = new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"};

        System.out.println(solution.solution(m, n, board));
    }
}
