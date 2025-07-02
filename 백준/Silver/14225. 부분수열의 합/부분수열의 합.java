import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static boolean[] visited, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        initArray();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);
        int i;
        for (i = 1; i < 2000000; ++i) {
            if (!cnt[i]) break;
        }
        System.out.println(i);
    }

    static void solve(int K, int val) {
        if (K == N) {
            if (val < 2000000) cnt[val] = true;
            return;
        }
        solve(K + 1, val);
        solve(K + 1, val + A[K]);
    }

    static void initArray() {
        A = new int[N];
        cnt = new boolean[2000000];
        visited = new boolean[N];
    }
}