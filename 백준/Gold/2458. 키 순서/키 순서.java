import java.io.*;
import java.util.*;

public class Main {
    static int INF = 987654321;
    static int N;
    static int[][] adj;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            dist[A][B] = 1;
        }
        for (int k = 1; k < N + 1; ++k) {
            for (int i = 1; i < N + 1; ++i) {
                for (int j = 1; j < N + 1; ++j) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int ans = 0, cnt;
        for (int i = 1; i < N + 1; ++i) {
            cnt = 0;
            for (int j = 1; j < N + 1; ++j) {
                if (dist[i][j] != INF || dist[j][i] != INF) cnt++;
            }
            if (cnt == N - 1) ans++;
        }
        System.out.println(ans);
    }

    static void initArray() {
        adj = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; ++i) {
            Arrays.fill(dist[i], INF);
        }
    }
}