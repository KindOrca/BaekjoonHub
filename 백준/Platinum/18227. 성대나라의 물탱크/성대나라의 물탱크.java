import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt;
    static int[] in, out, tree, depth;
    static boolean[] visited;
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
        depth[C] = 1;
        visited[C] = true;
        dfs(C);
        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            if (t == 1) {
                update(1, N, 1, in[A]);
            } else {
                sb.append(query(1, N, 1, in[A], out[A]) * depth[A]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int n) {
        in[n] = ++cnt;
        for (int next : adj[n]) {
            if (visited[next]) continue;
            visited[next] = true;
            depth[next] = depth[n] + 1;
            dfs(next);
        }
        out[n] = cnt;
    }

    static long query(int st, int en, int idx, int lo, int hi) {
        if (hi < st || en < lo) return 0;
        if (lo <= st && en <= hi) return tree[idx];
        int mid = (st + en) / 2;
        long le = query(st, mid, 2 * idx, lo, hi);
        long ri = query(mid + 1, en, 2 * idx + 1, lo, hi);
        return le + ri;
    }

    static void update(int st, int en, int idx, int pos) {
        if (pos < st || en < pos) return;
        tree[idx]++;
        if (st == en) return;
        int mid = (st + en) / 2;
        update(st, mid, 2 * idx, pos);
        update(mid + 1, en, 2 * idx + 1, pos);
    }

    static void initArray() {
        in = new int[N + 1];
        out = new int[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];
        tree = new int[4 * N];
        adj = new List[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adj[i] = new ArrayList<>();
        }
    }
}