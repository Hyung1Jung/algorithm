package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {
    static int[][][] block = {
            {{0,1}, {0,2}, {0,3}},
            {{1,0}, {2,0}, {3,0}},
            {{1,0}, {1,1}, {1,2}},
            {{0,1}, {1,0}, {2,0}},
            {{0,1}, {0,2}, {1,2}},
            {{1,0}, {2,0}, {2,-1}},
            {{0,1}, {0,2}, {-1,2}},
            {{1,0}, {2,0}, {2,1}},
            {{0,1}, {0,2}, {1,0}},
            {{0,1}, {1,1}, {2,1}},
            {{0,1}, {1,0}, {1,1}},
            {{0,1}, {-1,1}, {-1,2}},
            {{1,0}, {1,1}, {2,1}},
            {{0,1}, {1,1}, {1,2}},
            {{1,0}, {1,-1}, {2,-1}},
            {{0,1}, {0,2}, {-1,1}},
            {{0,1}, {0,2}, {1,1}},
            {{1,0}, {2,0}, {1,1}},
            {{1,0}, {2,0}, {1,-1}},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 문자형을 정수형으로 바꾸기 위해 Integer.parseInt
        int m = Integer.parseInt(st.nextToken());

        int[][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 0 ;i < n ; i++){
            for(int j = 0 ;j < m ; j++) {
                for(int k = 0; k<19; k++){
                    boolean ok = true;
                    int sum = paper[i][j];
                    for(int l=0; l<3; l++){
                        int x = i+block[k][l][0];
                        int y = j+block[k][l][1];
                        if (0 <= x && x < n && 0 <= y && y < m) {
                            sum += paper[x][y];
                        } else {
                            ok = false;
                            break;
                        }
                    }
                    if (ok && ans < sum) {
                        ans = sum;
                    }
                }
            }
        }
        System.out.println(ans);
    }

}
