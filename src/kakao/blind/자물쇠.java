package src.kakao.blind;

public class 자물쇠 {

    void match(int[][] arr, int[][] key, int rotation, int r, int c) {
        int n = key.length;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rotation == 0) {
                    arr[r + i][c + j] += key[i][j];
                } else if (rotation == 1) {
                    arr[r + i][c + j] += key[j][n - 1 - i];
                } else if (rotation == 2) {
                    arr[r + i][c + j] += key[n - 1 - i][n - 1 - j];
                } else {
                    arr[r + i][c + j] += key[n - 1 - j][i];
                }
            }
        }
    }

    boolean check(int[][] arr, int offset, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (arr[offset + i][offset + j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int offset = key.length - 1;

        for (int r = 0; r < offset + lock.length; ++r) {
            for (int c = 0; c < offset + lock.length; ++c) {
                for (int rotation = 0; rotation < 4; ++rotation) {
                    int[][] arr = new int[58][58];
                    for (int i = 0; i < lock.length; ++i) {
                        for (int j = 0; j < lock.length; ++j) {
                            arr[offset + i][offset + j] = lock[i][j];
                        }
                    }

                    match(arr, key, rotation, r, c);
                    if (check(arr, offset, lock.length)) {
                        return true;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        자물쇠 instance = new 자물쇠();
        System.out.println(instance.solution(new int[][]{{0, 0, 0,}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1,}, {1, 1, 0}, {1, 0, 1 }}));
    }

}
