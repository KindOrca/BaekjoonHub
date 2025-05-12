import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int INF = 987654321;
    static int[] A;
    static Point[] tree;

    static class Point {
        long Lmax, Rmax, Max, Sum;

        public Point(long Lmax, long Rmax, long Max, long Sum) {
            this.Lmax = Lmax;
            this.Rmax = Rmax;
            this.Max = Max;
            this.Sum = Sum;
        }
    }

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
        int M = Integer.parseInt(br.readLine());
        Point le, ri, mid;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            if (x2 < x1) x1 = x2;
            if (y2 < y1) y1 = y2;
            le = query(0, N - 1, 1, x1, y1);
            ri = query(0, N - 1, 1, x2, y2);
            if (y1 <= x2) {
                mid = query(0, N - 1, 1, y1, x2);
                sb.append(le.Rmax + ri.Lmax + mid.Sum - A[y1] - A[x2]);
            } else {
                mid = query(0, N - 1, 1, x2, y1);
                Point x1x2 = query(0, N - 1, 1, x1, x2);
                Point y1y2 = query(0, N - 1, 1, y1, y2);
                long a = query(0, N - 1, 1, x1, x2).Rmax + ri.Lmax - A[x2];
                long b = le.Rmax + query(0, N - 1, 1, y1, y2).Lmax - A[y1];
                long c = x1x2.Rmax + mid.Sum + y1y2.Lmax - A[x2] - A[y1];
                long d = mid.Max;
                sb.append(Math.max(Math.max(a, b), Math.max(c, d)));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void init(int st, int en, int idx) {
        if (st == en) {
            tree[idx] = new Point(A[st], A[st], A[st], A[st]);
            return;
        }
        int mid = (st + en) / 2;
        init(st, mid, 2 * idx);
        init(mid + 1, en, 2 * idx + 1);
        tree[idx] = merge(tree[2 * idx], tree[2 * idx + 1]);
    }

    static Point query(int st, int en, int idx, int lo, int hi) {
        if (hi < st || en < lo) return new Point(-INF, -INF, -INF, 0);
        if (lo <= st && en <= hi) return tree[idx];
        int mid = (st + en) / 2;
        Point le = query(st, mid, 2 * idx, lo, hi);
        Point ri = query(mid + 1, en, 2 * idx + 1, lo, hi);
        return merge(le, ri);
    }

    static Point merge(Point p1, Point p2) {
        long lmax = Math.max(p1.Lmax, p1.Sum + p2.Lmax);
        long rmax = Math.max(p2.Rmax, p2.Sum + p1.Rmax);
        long max = Math.max(Math.max(p1.Max, p2.Max), p1.Rmax + p2.Lmax);
        long sum = p1.Sum + p2.Sum;
        return new Point(lmax, rmax, max, sum);
    }

    static void initArray() {
        A = new int[N];
        tree = new Point[4 * N];
    }
}