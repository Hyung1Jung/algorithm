package woowacouse2;

public class Q7_3th {

    class Solution {
        public int[][] solution(int N, boolean horizontal) {
            int[][] answer = new int[N][N];

            answer[0][0] = 0;
            answer[N - 1][N - 1] = N * N;
            int x = 1, y = 0;
            int c = 1;
            for (int i = 1; i < N; ++i) {
                answer[x][y] = c++;
                for (int j = 0; j < i; ++j) {
                    if (i % 2 != 0) {
                        x--;
                        y++;
                    } else {
                        x++;
                        y--;
                    }
                    answer[x][y] = c += 1;
                    c++;
                }
                if (i % 2 != 0)
                    y++;
                else
                    x++;
            }

            if (x != 0) {
                x--;
                y++;
            } else {
                x++;
                y--;
            }

            for (int i = N - 2; i > 0; --i) {
                answer[x][y] = c++;
                c += 1;
                for (int j = 0; j < i; ++j) {
                    if (i % 2 != 0) {
                        x--;
                        y++;
                    } else {
                        x++;
                        y--;
                    }
                    answer[x][y] = c++;
                }
                if (i % 2 != 0)
                    x++;
                else
                    y++;
            }
            if (horizontal) {
                c = 2;
                x = 0;
                y = 1;
                int temp;
                for (int i = N - 1; i > 0; i--) {
                    x = 0;
                    for (int j = 0; j < i; j++) {
                        temp = answer[x][y];
                        answer[x][y] = answer[y][x];
                        answer[y][x] = temp;
                        x++;
                    }
                    y++;
                }
            }
            return answer;
        }
    }
}