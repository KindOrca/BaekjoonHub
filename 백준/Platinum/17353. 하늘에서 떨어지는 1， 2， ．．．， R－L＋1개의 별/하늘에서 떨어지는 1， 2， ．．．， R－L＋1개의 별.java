import java.io.*;
import java.util.*;

class Node {
    long start, cnt;
    public Node(long start, long cnt) {
        this.start = start;
        this.cnt = cnt;
    }
}

public class Main {
    static int N;
    static int[] A;
    static long[] tree;
    static Node[] lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        initArray();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        init(0, N - 1, 1);
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(st.nextToken());
            if (K == 1) {
                int L = Integer.parseInt(st.nextToken()) - 1;
                int R = Integer.parseInt(st.nextToken()) - 1;
                update(0, N - 1, 1, L, R, 1);
            } else {
                int X = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(0, N - 1, 1, X)).append("\n");
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
    }

    static void update(int st, int en, int idx, int lo, int hi, long val) {
        if (lazy[idx].start != 0) lazy_update(st, en, idx);
        if (hi < st || en < lo) return;
        int mid = (st + en) / 2;
        if (lo <= st && en <= hi) {
            if (st == en) {
                tree[idx] += val;
            } else {
                int len = mid - st + 1;
                lazy[2 * idx].start += val;
                lazy[2 * idx].cnt += 1;
                lazy[2 * idx + 1].start += val + len;
                lazy[2 * idx + 1].cnt += 1;
            }
            return;
        }
        int l_len = Math.max(0, Math.min(mid, hi) - Math.max(st, lo) + 1);
        update(st, mid, 2 * idx, lo, hi, val);
        update(mid + 1, en, 2 * idx + 1, lo, hi, val + l_len);
    }

    static void lazy_update(int st, int en, int idx) {
        if (st == en) {
            tree[idx] += lazy[idx].start;
        } else {
            int mid = (st + en) / 2;
            int len = mid - st + 1;
            lazy[2 * idx].start += lazy[idx].start;
            lazy[2 * idx].cnt += lazy[idx].cnt;
            lazy[2 * idx + 1].start += lazy[idx].start + lazy[idx].cnt * len;
            lazy[2 * idx + 1].cnt += lazy[idx].cnt;
        }
        lazy[idx] = new Node(0, 0);
    }

    static long query(int st, int en, int idx, int pos) {
        if (lazy[idx].start != 0) lazy_update(st, en, idx);
        if (pos < st || en < pos) return 0;
        if (st == en) return tree[idx];
        int mid = (st + en) / 2;
        long le = query(st, mid, 2 * idx, pos);
        long ri = query(mid + 1, en, 2 * idx + 1, pos);
        return le + ri;
    }

    static void initArray() {
        A = new int[N];
        tree = new long[4 * N];
        lazy = new Node[4 * N];
        for (int i = 0; i < 4 * N; ++i) {
            lazy[i] = new Node(0, 0);
        }
    }
}