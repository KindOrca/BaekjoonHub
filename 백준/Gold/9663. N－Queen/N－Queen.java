import java.io.*;

public class Main {
    static int N, cnt;
    static boolean[] visited, visitedL, visitedR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        initArray();
        NQueen(0);
        System.out.println(cnt);
    }

    static void NQueen(int K) {
        if (K == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; ++i) {
            if (visited[i] || visitedL[K + i] || visitedR[K - i + N]) continue;
            visited[i] = true;
            visitedL[K + i] = true;
            visitedR[K - i + N] = true;
            NQueen(K + 1);
            visited[i] = false;
            visitedL[K + i] = false;
            visitedR[K - i + N] = false;
        }
    }

    static void initArray() {
        visited = new boolean[N];
        visitedL = new boolean[2 * N];
        visitedR = new boolean[2 * N];
    }
}