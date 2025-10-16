import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] time, dp;
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        initArray();
        for (int i = 1; i < N + 1; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            while (p-- > 0) adj[Integer.parseInt(st.nextToken())].add(i);
        }
        int max = 0;
        for (int i = 1; i < N + 1; ++i) {
            max = Math.max(max, dfs(i));
        }
        System.out.println(max);
    }

    static int dfs(int cur) {
        int tmp = 0;
        for (int nxt : adj[cur]) {
            if (dp[nxt] == 0) tmp = Math.max(tmp, dfs(nxt));
            else tmp = Math.max(tmp, dp[nxt]);
        }
        return dp[cur] = tmp + time[cur];
    }

    static void initArray() {
        time = new int[N + 1];
        dp = new int[N + 1];
        adj = new List[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adj[i] = new ArrayList<>();
        }
    }
}