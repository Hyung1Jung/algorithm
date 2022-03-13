package src.kakao.blind;

import java.util.Arrays;

public class 프렌즈4블록 {

    static int M, N;
    static boolean check;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m;
        N = n;

        char[][] map = new char[m][n];

        for (int i = 0; i < m; ++i) {
            map[i] = board[i].toCharArray();
        }

        do {
            check = false;
            removeBlock(map);
            answer = mapSort(map);
        } while (check);

        return answer;
    }

    private void removeBlock(char[][] map) {
        char[][] checkMap = new char[M][N];

        for (int i = 0; i < M - 1; ++i) {
            for (int j = 0; j < N - 1; ++j) {
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
    }

    private int mapSort(char[][] map) {
        int count = 0;
        char[][] tempMap = deepCopy(map);

        for (int i = 1; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (map[i][j] == ' ') {
                    map[i][j] = map[i - 1][j];
                    map[i - 1][j] = ' ';
                }

                if (map[i - 1][j] == ' ') {
                    count++;
                }

                if (i == M - 1 && map[i][j] == ' ') {
                    count++;
                }
            }
        }

        if (!Arrays.deepEquals(tempMap, map)) {
            check = true;
        }

        return count;
    }

    private char[][] deepCopy(char[][] original2) {
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
