import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt;
    static int[] in, out;
    static long[] tree, lazy;
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
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch (a) {
                case 1:
                    long w = Long.parseLong(st.nextToken());
                    update_range(0, n - 1, 1, in[b] - 1, out[b] - 1, w);
                    break;
                case 2:
                    sb.append(query(0, n - 1, 1, in[b] - 1, in[b] - 1)).append("\n");
                    break;
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

    static long query(int st, int en, int idx, int lo, int hi) {
        update_lazy(st, en, idx);
        if (hi < st || en < lo) return 0;
        if (lo <= st && en <= hi) return tree[idx];
        int mid = (st + en) / 2;
        long le = query(st, mid, 2 * idx, lo, hi);
        long ri = query(mid + 1, en, 2 * idx + 1, lo, hi);
        return le + ri;
    }

    static void update_range(int st, int en, int idx, int lo, int hi, long val) {
        update_lazy(st, en, idx);
        if (hi < st || en < lo) return;
        if (lo <= st && en <= hi) {
            tree[idx] += (en - st + 1) * val;
            if (st != en) {
                lazy[2 * idx] += val;
                lazy[2 * idx + 1] += val;
            }
            return;
        }
        int mid = (st + en) / 2;
        update_range(st, mid, 2 * idx, lo, hi, val);
        update_range(mid + 1, en, 2 * idx + 1, lo, hi, val);
        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    static void update_lazy(int st, int en, int idx) {
        if (lazy[idx] == 0) return;
        tree[idx] += (en - st + 1) * lazy[idx];
        if (st != en) {
            lazy[2 * idx] += lazy[idx];
            lazy[2 * idx + 1] += lazy[idx];
        }
        lazy[idx] = 0;
    }

    static void initArray() {
        in = new int[n + 1];
        out = new int[n + 1];
        tree = new long[4 * n];
        lazy = new long[4 * n];
        adj = new List[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            adj[i] = new ArrayList<>();
        }
    }
}