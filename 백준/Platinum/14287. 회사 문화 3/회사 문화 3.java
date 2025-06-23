import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt;
    static int[] in, out, tree, lazy;
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        initArray();
        st = new StringTokenizer(br.readLine(), " ");
        st.nextToken();
        for (int i = 2; i < n + 1; ++i) {
            int p = Integer.parseInt(st.nextToken());
            adj[p].add(i);
        }
        dfs(1);
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            if (t == 1) {
                int w = Integer.parseInt(st.nextToken());
                update(0, n - 1, 1, in[i] - 1, w);
            } else {
                sb.append(query(0, n - 1, 1, in[i] - 1, out[i] - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int n) {
        in[n] = ++cnt;
        for (int next : adj[n]) {
            dfs(next);
        }
        out[n] = cnt;
    }

    static int query(int st, int en, int idx, int lo, int hi) {
        if (hi < st || en < lo) return 0;
        if (lo <= st && en <= hi) return tree[idx];
        int mid = (st + en) / 2;
        int le = query(st, mid, 2 * idx, lo, hi);
        int ri = query(mid + 1, en, 2 * idx + 1, lo, hi);
        return le + ri;
    }

    static void update(int st, int en, int idx, int pos, int val) {
        if (pos < st || en < pos) return;
        tree[idx] += val;
        if (st == en) return;
        int mid = (st + en) / 2;
        update(st, mid, 2 * idx, pos, val);
        update(mid + 1, en, 2 * idx + 1, pos, val);
        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    static void initArray() {
        in = new int[n + 1];
        out = new int[n + 1];
        tree = new int[4 * n];
        lazy = new int[4 * n];
        adj = new List[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            adj[i] = new ArrayList<>();
        }
    }
}