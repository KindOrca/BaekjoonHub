import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt;
    static int[] in, out, treeRange, tree, lazy;
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
        boolean flag = true;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            switch (t) {
                case 1:
                    int i = Integer.parseInt(st.nextToken());
                    int w = Integer.parseInt(st.nextToken());
                    if (flag) update_range(1, n, 1, in[i], out[i], w);
                    else update(1, n, 1, in[i], w);
                    break;
                case 2:
                    int p = Integer.parseInt(st.nextToken());
                    sb.append(query(1, n, 1, in[p]) + query(1, n, 1, in[p], out[p])).append("\n");
                    break;
                case 3:
                    flag = !flag;
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

    static int query(int st, int en, int idx, int pos) {
        update_lazy(st, en, idx);
        if (pos < st || en < pos) return 0;
        if (st == en) return treeRange[idx];
        int mid = (st + en) / 2;
        if (mid >= pos) return query(st, mid, 2 * idx, pos);
        else return query(mid + 1, en, 2 * idx + 1, pos);
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

    static void update_range(int st, int en, int idx, int lo, int hi, int val) {
        update_lazy(st, en, idx);
        if (hi < st || en < lo) return;
        if (lo <= st && en <= hi) {
            treeRange[idx] += (en - st + 1) * val;
            if (st != en) {
                lazy[2 * idx] += val;
                lazy[2 * idx + 1] += val;
            }
            return;
        }
        int mid = (st + en) / 2;
        update_range(st, mid, 2 * idx, lo, hi, val);
        update_range(mid + 1, en, 2 * idx + 1, lo, hi, val);
        treeRange[idx] = treeRange[2 * idx] + treeRange[2 * idx + 1];
    }

    static void update_lazy(int st, int en, int idx) {
        if (lazy[idx] == 0) return;
        treeRange[idx] += (en - st + 1) * lazy[idx];
        if (st != en) {
            lazy[2 * idx] += lazy[idx];
            lazy[2 * idx + 1] += lazy[idx];
        }
        lazy[idx] = 0;
    }

    static void initArray() {
        in = new int[n + 1];
        out = new int[n + 1];
        tree = new int[4 * n];
        treeRange = new int[4 * n];
        lazy = new int[4 * n];
        adj = new List[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            adj[i] = new ArrayList<>();
        }
    }
}