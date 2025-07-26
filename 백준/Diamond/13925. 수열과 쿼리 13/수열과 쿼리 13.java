import java.io.*;
import java.util.*;

class Node {
    long mult, plus;
    Node(long mult, long plus) {
        this.mult = mult;
        this.plus = plus;
    }
}

public class Main {
    static int N, MOD = 1000000007;
    static long[] A, tree;
    static Node[] lazy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        initArray();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) A[i] = Long.parseLong(st.nextToken()) % MOD;
        init(0, N - 1, 1);
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (t != 4) {
                int v = Integer.parseInt(st.nextToken());
                update_range(0, N - 1, 1, a, b, v, t);
            } else {
                sb.append(query(0, N - 1, 1, a, b)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void init(int st, int en, int idx) {
        if (st == en) {
            tree[idx] = A[st];
            return;
        }
        int mid = (st + en) / 2;
        init(st, mid, 2 * idx);
        init(mid + 1, en, 2 * idx + 1);
        tree[idx] = (tree[2 * idx] + tree[2 * idx + 1]) % MOD;
    }

    static long query(int st, int en, int idx, int lo, int hi) {
        update_lazy(st, en, idx);
        if (hi < st || en < lo) return 0;
        if (lo <= st && en <= hi) return tree[idx];
        int mid = (st + en) / 2;
        long le = query(st, mid, 2 * idx, lo, hi);
        long ri = query(mid + 1, en, 2 * idx + 1, lo, hi);
        return (le + ri) % MOD;
    }

    static void update_range(int st, int en, int idx, int lo, int hi, long val, int type) {
        update_lazy(st, en, idx);
        if (hi < st || en < lo) return;
        if (lo <= st && en <= hi) {
            if (type == 1) {
                lazy[idx].mult = 1;
                lazy[idx].plus = val;
            } else if (type == 2) {
                lazy[idx].mult = val;
                lazy[idx].plus = 0;
            } else {
                lazy[idx].mult = 0;
                lazy[idx].plus = val;
            }
            update_lazy(st, en, idx);
            return;
        }
        int mid = (st + en) / 2;
        update_range(st, mid, 2 * idx, lo, hi, val, type);
        update_range(mid + 1, en, 2 * idx + 1, lo, hi, val, type);
        tree[idx] = (tree[2 * idx] + tree[2 * idx + 1]) % MOD;
    }

    static void update_lazy(int st, int en, int idx) {
        if (lazy[idx].mult == 0 && lazy[idx].plus == 0) return;
        tree[idx] = (tree[idx] * lazy[idx].mult + (en - st + 1) * lazy[idx].plus) % MOD;
        if (st != en) {
            lazy[2 * idx].mult = lazy[2 * idx].mult * lazy[idx].mult % MOD;
            lazy[2 * idx].plus = (lazy[2 * idx].plus * lazy[idx].mult + lazy[idx].plus) % MOD;
            lazy[2 * idx + 1].mult = lazy[2 * idx + 1].mult * lazy[idx].mult % MOD;
            lazy[2 * idx + 1].plus = (lazy[2 * idx + 1].plus * lazy[idx].mult + lazy[idx].plus) % MOD;
        }
        lazy[idx].mult = 1;
        lazy[idx].plus = 0;
    }

    static void initArray() {
        A = new long[N];
        tree = new long[4 * N];
        lazy = new Node[4 * N];
        for (int i = 0; i < 4 * N; ++i) {
            lazy[i] = new Node(1, 0);
        }
    }
}