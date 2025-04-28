import java.io.*;
import java.util.*;

class Node {
    int B, D;
    public Node(int B, int D) {
        this.B = B;
        this.D = D;
    }
}

public class Main {
    static int N, logN;
    static int[][] sparse;
    static int[][] sparseDist;
    static int[] depth;
    static List<Node>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        initArray();
        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            adj[A].add(new Node(B, D));
            adj[B].add(new Node(A, D));
        }
        dfs(1, 0);
        makeSparse();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(query(A, B)).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int cur, int prv) {
        for (Node nxt : adj[cur]) {
            if (nxt.B == prv) continue;
            sparse[0][nxt.B] = cur;
            sparseDist[0][nxt.B] = nxt.D;
            depth[nxt.B] = depth[cur] + 1;
            dfs(nxt.B, cur);
        }
    }

    static void makeSparse() {
        for (int i = 1; i < logN; ++i) {
            for (int j = 1; j < N + 1; ++j) {
                int nxt = sparse[i - 1][j];
                sparse[i][j] = sparse[i - 1][nxt];
                sparseDist[i][j] = sparseDist[i - 1][nxt] + sparseDist[i - 1][j];
            }
        }
    }

    static int query(int A, int B) {
        int length = 0;
        if (depth[A] < depth[B]) {
            int temp = A;
            A = B;
            B = temp;
        }
        for (int i = logN - 1; i > -1; --i) {
            if (depth[A] - depth[B] >= (1 << i)) {
                length += sparseDist[i][A];
                A = sparse[i][A];
            }
        }
        if (A == B) return length;
        for (int i = logN - 1; i > -1; --i) {
            if (sparse[i][A] != sparse[i][B]) {
                length += sparseDist[i][A];
                length += sparseDist[i][B];
                A = sparse[i][A];
                B = sparse[i][B];
            }
        }
        length += sparseDist[0][A];
        length += sparseDist[0][B];
        return length;
    }

    static void initArray() {
        logN = (int) Math.ceil(Math.log(N) / Math.log(2));
        sparse = new int[logN][N + 1];
        sparseDist = new int[logN][N + 1];
        depth = new int[N + 1];
        adj = new List[N + 1];
        for (int i = 0; i < N + 1; ++i) {
            adj[i] = new ArrayList<>();
        }
    }
}