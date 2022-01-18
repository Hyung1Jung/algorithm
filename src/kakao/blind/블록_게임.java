package src.kakao.blind;

// 시간 초

public class 블록_게임 {

    int N;
    int[][] Board;

    boolean canFill(int row, int col) {
        for (int i = 0; i < row; ++i) {

            if (Board[i][col] != 0) {
                return false;
            }

        }

        return true;
    }

    boolean find(int row, int col, int height, int weigh) {
        int emptyCount = 0;
        int lastValue = -1;

        for (int r = row; r < row + height; ++row) {
            for (int c = col; c < col + weigh; ++col) {

                if (Board[r][c] == 0) {

                    if (!canFill(r, c)) {
                        return false;
                    }

                    if (++emptyCount > 2) {
                        return false;
                    }

                } else {

                    if (lastValue != -1 && lastValue != Board[r][c]) {
                        return false;
                    }

                    lastValue = Board[r][c];
                }
            }
        }

        for (int r = row; r < row + height; ++r) {
            for (int c = col; c < col + weigh; ++c) {
                Board[r][c] = 0;
            }
        }

        return true;
    }

    public int solution(int[][] board) {
        Board = board;
        N = board.length;

        int answer = 0;
        int count;

        do {
            count = 0;

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {

                    if (i <= N - 2 && j <= N - 3 && find(i, j, 2, 3)) {
                        ++count;
                    } else if (i <= N - 3 && j <= N - 2 && find(i, j, 3, 2)) {
                        ++count;
                    }

                }
            }
            answer += count;
        } while (count != 0);

        return answer;
    }

    public static void main(String[] args) {
        블록_게임 instance = new 블록_게임();

        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 4, 0, 0, 0},
                {0, 0, 0, 0, 0, 4, 4, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 4, 0, 0, 0},
                {0, 0, 0, 2, 3, 0, 0, 0, 5, 5},
                {1, 2, 2, 2, 3, 3, 0, 0, 0, 5},
                {1, 1, 1, 0, 0, 0, 0, 0, 0, 5}
        };

        System.out.println(instance.solution(board));
    }
}

