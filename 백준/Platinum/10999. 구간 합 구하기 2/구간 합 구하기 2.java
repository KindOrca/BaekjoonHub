import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] A, tree, lazy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 0; i < N; ++i) A[i] = Long.parseLong(br.readLine());
        init(0, N - 1, 1);
        for (int i = 0; i < M + K; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                update_range(0, N - 1, 1, b, c, d);
            } else {
                sb.append(query(0, N - 1, 1, b, c)).append("\n");
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
        tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
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
        A = new long[N];
        tree = new long[4 * N];
        lazy = new long[4 * N];
    }
}