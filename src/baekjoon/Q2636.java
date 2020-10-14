package baekjoon;

import java.util.*;
import java.io.*;

public class Q2636 {
    static int N, M;	// 행, 열
    static int[][] cheeseMap;	// 치즈판 (0:방문하지 않은공기, 1:치즈, -1:방문한 공기, 2:녹을 치즈)
    static int cheeseLast;	// 마지막 남은 치즈 개수
    static int[] rx = { -1, 1, 0, 0 };
    static int[] ry = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 문자형을 정수형으로 바꾸기 위해 Integer.parseInt
        M = Integer.parseInt(st.nextToken());

        cheeseMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                cheeseMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        // 치즈가 없을 때까지 공기를 중심으로 탐색
        do {
            dfs(0, 0);	// 공기의 첫좌표인 (0,0)부터 시작
            time++;
        }while(cheeseCheck());

        // 치즈가 있는지 체크

        System.out.println(time - 1);
        System.out.println(cheeseLast);
    }// end of main

    private static void dfs(int x, int y) {
        cheeseMap[x][y] = -1;	// 공기에 대한 방문 처리
        int nx, ny;
        // 공기를 중심으로 사방에 치즈가 있는지 검사
        for (int d = 0; d < 4; d++) {
            ny = x + rx[d];
            nx = y + ry[d];
            if(ny > -1 && ny < N && nx > -1 && nx < M) {
                // 치즈(1)면 -> 공기 옆 치즈이므로 녹을 치즈(2)로 표시
                if(cheeseMap[ny][nx] == 1) {
                    cheeseMap[ny][nx] = 2;
                    d = 0;
                } else if(cheeseMap[ny][nx] == 0) {	// 공기(0)면 -> 계속 탐색
                    dfs(ny, nx);                    // 재귀함수
                }
            }
        }
    }

    private static boolean cheeseCheck() {
        int count = 0;
        // 전체 치즈판을 탐색하면서
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheeseMap[i][j] == 1)
                    continue;
                if (cheeseMap[i][j] == 2)	// 녹을 치즈(2)면 count를 센 후에 녹여준다. --> 0으로 바꾼다.
                    count++;
                // 녹을 치즈와 방문한 공기(-1)면 다시 탐색하기 위해서 0으로 바꿔준다.
                cheeseMap[i][j] = 0;
            }
        }

        if (count == 0) {
            return false;        // count가 0이 되서 false면 do ~while문 종료
        } else {
            cheeseLast = count;
            return true;         // true면 do{} 다시 실행
        }
    }

}