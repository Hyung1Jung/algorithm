package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*

백준 Q2644_촌수계산

         1            |         4
     2       3        |      5     6
  7  8  9             |

풀이전략:
7번과 3번의 촌수(cnt)를 계산해본다. cnt는 0에서 시작하고 먼저 7의 부모가 3인지 확인한다.
확인해본후 3이 아니고 2이므로 cnt를 1로 증가시키고 2번으로 이동한다. 2에서는 1, 7, 8, 9 총 4명을 확인할 수 있다.
이중에 3이 있는지 보자. 3이 없으므로 cnt를 1 증가시키고 1, 8, 9 각각에 대하여 이동하고 3이 있는지 확인하는 작업을 반복한다.
1로 시선을 이동하여 3을 찾아본다.
1번에서 확인 할 수있는 사람은 2와 3이 있다. 이중에 3이 있으므로 cnt를 1 증가시키고 종료한다.
따라서 7번과 3번의 촌수는 3이라는 사실을 알 수 있다.

1.  사람들의 관계를 양방향 인접리스트로 구헀다.
2.  촌수를 계산할 사람 2명 중 1명을 시작점으로 두고, 나머지 1명을 끝점으로 설정한 후,
    DFS를 통해 끝점에 도달할 때까지 반복한다. 이 때, cnt를 1씩 증가시키면서 반복한다.
2-1 끝점에 도달할 경우, cnt의 값을 출력하고 종료한다.
2-2 끝점에 도달할 수 없는 경우 -1을 출력하고 종료한다.

 */
public class Q2644 {
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int findX = Integer.parseInt(st.nextToken());
        int findY = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());
        // 양방향 인접리스트 구현.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            a.get(x).add(y);
            a.get(y).add(x);
        }

        boolean[] visited = new boolean[N + 1];
        DFS(a, visited, findX, findY, 0);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // DFS를 이용하여 촌수 계산.
    public static void DFS(ArrayList<ArrayList<Integer>> a, boolean[] visited, int pos, int find, int cnt) {
        visited[pos] = true;

        for (int i : a.get(pos)) {
            if (!visited[i]) {
                if (i == find) { // 찾으려는 사람의 도달.
                    ans = cnt + 1;
                    return;
                }

                DFS(a, visited, i, find, cnt + 1);
            }
        }
    }
}
