import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] tree, lazy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        st.nextToken();
        int Q = Integer.parseInt(st.nextToken());
        initArray();
        init(0, N - 1, 1);
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            if (s.equals("C")) {
                int z = Integer.parseInt(st.nextToken()) - 1;
                update_range(0, N - 1, 1, x, y, z);
            } else {
                int ret = query(0, N - 1, 1, x, y);
                int cnt = 0;
                while (ret != 0) {
                    cnt += (ret & 1);
                    ret >>= 1;
                }
                sb.append(cnt).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void init(int st, int en, int idx) {
        tree[idx] = 1;
        if (st == en) return;
        int mid = (st + en) / 2;
        init(st, mid, 2 * idx);
        init(mid + 1, en, 2 * idx + 1);
    }

    static int query(int st, int en, int idx, int lo, int hi) {
        update_lazy(st, en, idx);
        if (hi < st || en < lo) return 0;
        if (lo <= st && en <= hi) return tree[idx];
        int mid = (st + en) / 2;
        int le = query(st, mid, 2 * idx, lo, hi);
        int ri = query(mid + 1, en, 2 * idx + 1, lo, hi);
        return le | ri;
    }

    static void update_range(int st, int en, int idx, int lo, int hi, int val) {
        update_lazy(st, en, idx);
        if (hi < st || en < lo) return;
        if (lo <= st && en <= hi) {
            tree[idx] = 1 << val;
            if (st != en) {
                lazy[2 * idx] = 1 << val;
                lazy[2 * idx + 1] = 1 << val;
            }
            return;
        }
        int mid = (st + en) / 2;
        update_range(st, mid, 2 * idx, lo, hi, val);
        update_range(mid + 1, en, 2 * idx + 1, lo, hi, val);
        tree[idx] = tree[2 * idx] | tree[2 * idx + 1];
    }

    static void update_lazy(int st, int en, int idx) {
        if (lazy[idx] == 0) return;
        tree[idx] = lazy[idx];
        if (st != en) {
            lazy[2 * idx] = lazy[idx];
            lazy[2 * idx + 1] = lazy[idx];
        }
        lazy[idx] = 0;
    }

    static void initArray() {
        tree = new int[4 * N];
        lazy = new int[4 * N];
    }
}