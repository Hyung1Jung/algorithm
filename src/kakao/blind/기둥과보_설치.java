package src.kakao.blind;

import java.util.Arrays;

public class 기둥과보_설치 {
    boolean[][] Pillar;
    boolean[][] Bar;

    int count = 0;

    boolean checkPillar(int x, int y) {
        if (y == 0 || Pillar[x][y - 1]) {
            return true;
        }

        if ((x > 0 && Bar[x - 1][y]) || Bar[x][y]) {
            return true;
        }

        return false;
    }

    boolean checkBar(int x, int y) {
        if (Pillar[x][y - 1] || Pillar[x + 1][y - 1]) {
            return true;
        }

        if (x > 0 && Bar[x - 1][y] && Bar[x + 1][y]) {
            return true;
        }

        return false;
    }


    boolean canDelete(int x, int y) {
        for (int i = Math.max(x - 1, 0); i <= x + 1; ++i) {
            for (int j = y; j <= y + 1; ++j) {

                if (Pillar[i][j] && !checkPillar(i, j)) {
                    return false;
                }

                if (Bar[i][j] && !checkBar(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};

        Pillar = new boolean[n + 2][n + 2];
        Bar = new boolean[n + 2][n + 2];

        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int type = build[2];
            int cmd = build[3];

            if (type == 0) {

                if (cmd == 1) {

                    if (checkPillar(x, y)) {
                        Pillar[x][y] = true;
                        count++;
                    }

                } else {
                    Pillar[x][y] = false;

                    if (!canDelete(x, y)) {
                        Pillar[x][y] = true;
                    } else {
                        count--;
                    }
                }

            } else {

                if (cmd == 1) {

                    if (checkBar(x, y)) {
                        Bar[x][y] = true;
                        count++;
                    }

                } else {
                    Bar[x][y] = false;

                    if (!canDelete(x, y)) {
                        Bar[x][y] = true;
                    } else {
                        count--;
                    }
                }

            }
        }

        answer = new int[count][3];
        count = 0;

        for (int x = 0; x <= n; ++x) {
            for (int y = 0; y <= n; ++y) {

                if (Pillar[x][y]) {
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count++][2] = 0;
                }

                if (Bar[x][y]) {
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count++][2] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        기둥과보_설치 instance = new 기둥과보_설치();

        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1,}};
        System.out.println(Arrays.deepToString(instance.solution(5, build_frame)));
    }
}
