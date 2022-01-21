package src.kakao.blind;

import java.util.Arrays;

public class 외벽점검 {

    static final int INF = 9128391;
    int N;
    int minCnt;
    int[] weak;
    int[] dist;

    void solve(int cnt, int pos, int visited) {

        if (cnt > dist.length) {
            return;
        }

        if (cnt >= minCnt) {
            return;
        }

        for (int i = 0; i < weak.length; ++i) {
            int nextPos = (pos + i) % weak.length;
            int diff = weak[nextPos] - weak[pos];

            if (nextPos < pos) {
                diff += N;
            }

            if (diff > dist[dist.length - cnt]) {
                break;
            }

            visited |= 1 << nextPos;
        }

        if (visited == (1 << weak.length) - 1) {
            minCnt = cnt;
            return;
        }

        for (int i = 0; i < weak.length; ++i) {

            if ((visited & (1 << i)) != 0) {
                continue;
            }

            solve(cnt + 1, i, visited);
        }
    }

    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;

        Arrays.sort(dist);

        N = n;
        this.weak = weak;
        this.dist = dist;
        this.minCnt = INF;

        for (int i = 0; i < weak.length; ++i) {
            solve(1, i, 0);
        }

        if (minCnt == INF) {
            return -1;
        }

        answer = minCnt;

        return answer;
    }

    public static void main(String[] args) {
        외벽점검 instance = new 외벽점검();

        int[] weak = new int[]{1, 5, 6, 10};
        int[] dist = new int[]{1, 2, 3, 4};
        System.out.println(instance.solution(12, weak, dist));
    }
}
