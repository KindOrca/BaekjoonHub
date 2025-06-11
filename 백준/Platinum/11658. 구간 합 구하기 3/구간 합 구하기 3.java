import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] A;
    static int[][] tree;
    static int[][] tree2D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; ++i) {
            init(0, N - 1, 1, i);
        }
        init(0, N - 1, 1);
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            if (w == 0) {
                int c = Integer.parseInt(st.nextToken());
                update(0, N - 1, 1, y, x, c);
                update2D(0, N - 1, 1, x);
            } else {
                int x2 = Integer.parseInt(st.nextToken()) - 1;
                int y2 = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(0, N - 1, 1, y, x, y2, x2)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void init(int st, int en, int idx, int y) {
        if (st == en) {
            tree[y][idx] = A[y][st];
            return;
        }
        int mid = (st + en) / 2;
        init(st, mid, 2 * idx, y);
        init(mid + 1, en, 2 * idx + 1, y);
        tree[y][idx] = tree[y][2 * idx] + tree[y][2 * idx + 1];
    }

    static void init(int st, int en, int idx) {
        if (st == en) {
            tree2D[idx] = tree[st];
            return;
        }
        int mid = (st + en) / 2;
        init(st, mid, 2 * idx);
        init(mid + 1, en, 2 * idx + 1);
        for (int i = 0; i < 4 * N; ++i) {
            tree2D[idx][i] = tree2D[2 * idx][i] + tree2D[2 * idx + 1][i];
        }
    }

    static void update(int st, int en, int idx, int x, int y, int val) {
        if (x < st || en < x) return;
        if (st == en) {
            tree[y][idx] = val;
            return;
        }
        int mid = (st + en) / 2;
        update(st, mid, 2 * idx, x, y, val);
        update(mid + 1, en, 2 * idx + 1, x, y, val);
        tree[y][idx] = tree[y][2 * idx] + tree[y][2 * idx + 1];
    }

    static void update2D(int st, int en, int idx, int y) {
        if (y < st || en < y) return;
        if (st == en) {
            tree2D[idx] = tree[st];
            return;
        }
        int mid = (st + en) / 2;
        update2D(st, mid, 2 * idx, y);
        update2D(mid + 1, en, 2 * idx + 1, y);
        for (int i = 0; i < 4 * N; ++i) {
            tree2D[idx][i] = tree2D[2 * idx][i] + tree2D[2 * idx + 1][i];
        }
    }

    static int queryX(int st, int en, int idx, int lo, int hi, int y) {
        if (hi < st || en < lo) return 0;
        if (lo <= st && en <= hi) return tree2D[y][idx];
        int mid = (st + en) / 2;
        int le = queryX(st, mid, 2 * idx, lo, hi, y);
        int ri = queryX(mid + 1, en, 2 * idx + 1, lo, hi, y);
        return le + ri;
    }

    static int query(int st, int en, int idx, int x1, int y1, int x2, int y2) {
        if (y2 < st || en < y1) return 0;
        if (y1 <= st && en <= y2) {
            return queryX(0, N - 1, 1, x1, x2, idx);
        }
        int mid = (st + en) / 2;
        int le = query(st, mid, 2 * idx, x1, y1, x2, y2);
        int ri = query(mid + 1, en, 2 * idx + 1, x1, y1, x2, y2);
        return le + ri;
    }

    static void initArray() {
        A = new int[N][N];
        tree = new int[N][4 * N];
        tree2D = new int[4 * N][4 * N];
    }
}