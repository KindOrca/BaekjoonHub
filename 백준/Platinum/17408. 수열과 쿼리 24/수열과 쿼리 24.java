import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static Node[] tree;

    static class Node {
        int One, Two;
        public Node(int One, int Two) {
            this.One = One;
            this.Two = Two;
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
        int Q = Integer.parseInt(br.readLine());
        for (int t = 0; t < Q; ++t) {
            st = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(st.nextToken());
            if (K == 1) {
                int i = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken());
                update(0, N - 1, 1, i, v);
            } else {
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                Node n = query(0, N - 1, 1, l, r);
                sb.append(n.One + n.Two).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void init(int st, int en, int idx) {
        if (st == en) {
            tree[idx] = new Node(A[st], 0);
            return;
        }
        int mid = (st + en) / 2;
        init(st, mid, 2 * idx);
        init(mid + 1, en, 2 * idx + 1);
        tree[idx] = merge(tree[2 * idx], tree[2 * idx + 1]);
    }

    static Node query(int st, int en, int idx, int lo, int hi) {
        if (hi < st || en < lo) return new Node(0, 0);
        if (lo <= st && en <= hi) return tree[idx];
        int mid = (st + en) / 2;
        Node le = query(st, mid, 2 * idx, lo, hi);
        Node ri = query(mid + 1, en, 2 * idx + 1, lo, hi);
        return merge(le, ri);
    }

    static void update(int st, int en, int idx, int pos, int val) {
        if (pos < st || en < pos) return;
        if (st == en) {
            tree[idx] = new Node(val, 0);
            return;
        }
        int mid = (st + en) / 2;
        update(st, mid, 2 * idx, pos, val);
        update(mid + 1, en, 2 * idx + 1, pos, val);
        tree[idx] = merge(tree[2 * idx], tree[2 * idx + 1]);
    }

    static Node merge(Node n1, Node n2) {
        int[] a = new int[4];
        a[0] = n1.One;
        a[1] = n1.Two;
        a[2] = n2.One;
        a[3] = n2.Two;
        Arrays.sort(a);
        return new Node(a[3], a[2]);
    }

    static void initArray() {
        A = new int[N];
        tree = new Node[4 * N];
    }
}