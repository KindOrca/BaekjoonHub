import java.io.*;
import java.util.*;

class Node {
    long val;
    int idx;
    public Node(long val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

public class Main {
    static int N;
    static long ans;
    static int[] A;
    static long[] treeSum;
    static Node[] treeMin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        initArray();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        init(0, N - 1, 1);
        solve(0, N - 1);
        System.out.println(ans);
    }

    static void solve(int st, int en) {
        if (st > en) return;
        Node min = queryMin(0, N - 1, 1, st, en);
        ans = Math.max(ans, min.val * querySum(0, N - 1, 1, st, en));
        solve(st, min.idx - 1);
        solve(min.idx + 1, en);
    }

    static void init(int st, int en, int idx) {
        if (st == en) {
            treeSum[idx] = A[st];
            treeMin[idx] = new Node(A[st], st);
            return;
        }
        int mid = (st + en) / 2;
        init(st, mid, 2 * idx);
        init(mid + 1, en, 2 * idx + 1);
        treeSum[idx] = treeSum[2 * idx] + treeSum[2 * idx + 1];
        treeMin[idx] = merge(treeMin[2 * idx], treeMin[2 * idx + 1]);
    }

    static Node merge(Node n1, Node n2) {
        if (n1.val <= n2.val) return n1;
        else return n2;
    }

    static long querySum(int st, int en, int idx, int lo, int hi) {
        if (hi < st || en < lo) return 0;
        if (lo <= st && en <= hi) return treeSum[idx];
        int mid = (st + en) / 2;
        long le = querySum(st, mid, 2 * idx, lo, hi);
        long ri = querySum(mid + 1, en, 2 * idx + 1, lo, hi);
        return le + ri;
    }

    static Node queryMin(int st, int en, int idx, int lo, int hi) {
        if (hi < st || en < lo) return new Node(Integer.MAX_VALUE, -1);
        if (lo <= st && en <= hi) return treeMin[idx];
        int mid = (st + en) / 2;
        Node le = queryMin(st, mid, 2 * idx, lo, hi);
        Node ri = queryMin(mid + 1, en, 2 * idx + 1, lo, hi);
        return merge(le, ri);
    }

    static void initArray() {
        ans = Long.MIN_VALUE;
        A = new int[N];
        treeSum = new long[4 * N];
        treeMin = new Node[4 * N];
    }
}