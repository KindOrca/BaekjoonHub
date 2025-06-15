import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] A, B;
    static int MOD = 1_000_000_009;
    static long[][][] dp, pSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        initArray();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; ++i) B[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);
        Arrays.sort(B);

        for (int k = 0; k < K; ++k) {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (A[i] > B[j]) {
                        if (k == 0) {
                            dp[i][j][k] = 1;
                        } else {
                            dp[i][j][k] = pSum[i][j][k - 1];
                        }
                    }
                }
            }
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    pSum[i + 1][j + 1][k] = (pSum[i + 1][j][k] + pSum[i][j + 1][k] - pSum[i][j][k] + dp[i][j][k] + MOD) % MOD;
                }
            }
        }
        System.out.println(pSum[N][M][K - 1]);
    }

    static void initArray() {
        A = new int[N];
        B = new int[M];
        dp = new long[N][M][K];
        pSum = new long[N + 1][M + 1][K];
    }
}