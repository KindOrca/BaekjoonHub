import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt;
    static int[] A, salary, in, out, tree, lazy;
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        initArray();
        salary[1] = Integer.parseInt(br.readLine());
        for (int i = 2; i < N + 1; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            salary[i] = Integer.parseInt(st.nextToken());
            adj[Integer.parseInt(st.nextToken())].add(i);
        }
        dfs(1);
        init(1, N, 1);
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            if (s.equals("p")) {
                int x = Integer.parseInt(st.nextToken());
                update_range(1, N, 1, in[a] + 1, out[a], x);
            } else {
                sb.append(query(1, N, 1, in[a], in[a])).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int n) {
        in[n] = ++cnt;
        A[in[n]] = salary[n];
        for (int next : adj[n]) {
            dfs(next);
        }
        out[n] = cnt;
    }

    static void init(int st, int en, int idx) {
        if (st == en) {
            tree[idx] = A[st];
            return;
        }
        int mid = (st + en) / 2;
        init(st, mid, 2 * idx);
        init(mid + 1, en, 2 * idx + 1);
        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
    }

    static int query(int st, int en, int idx, int lo, int hi) {
        update_lazy(st, en, idx);
        if (hi < st || en < lo) return 0;
        if (lo <= st && en <= hi) return tree[idx];
        int mid = (st + en) / 2;
        int le = query(st, mid, 2 * idx, lo, hi);
        int ri = query(mid + 1, en, 2 * idx + 1, lo, hi);
        return le + ri;
    }

    static void update_range(int st, int en, int idx, int lo, int hi, int val) {
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
        A = new int[N + 1];
        salary = new int[N + 1];
        in = new int[N + 1];
        out = new int[N + 1];
        tree = new int[4 * N];
        lazy = new int[4 * N];
        adj = new List[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adj[i] = new ArrayList<>();
        }
    }
}