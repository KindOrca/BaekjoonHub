import java.io.*;
import java.util.*;

class Node {
    int b;
    long t;
    Node(int b, long t) {
        this.b = b;
        this.t = t;
    }
}

public class Main {
    static int N, M;
    static long INF = 10000000001L;
    static long[] dist;
    static boolean[] sight;
    static List<Node>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        initArray();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            sight[i] = Integer.parseInt(st.nextToken()) == 1;
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, t));
            adj[b].add(new Node(a, t));
        }
        solve();
        System.out.println(dist[N - 1] == INF ? -1 : dist[N - 1]);
    }

    static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Math.toIntExact(n1.t - n2.t));
        pq.add(new Node(0, 0));
        dist[0] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.t > dist[cur.b]) continue;
            for (Node next : adj[cur.b]) {
                if (sight[next.b] && next.b != N - 1) continue;
                if (dist[next.b] <= dist[cur.b] + next.t) continue;
                dist[next.b] = dist[cur.b] + next.t;
                pq.add(new Node(next.b, dist[next.b]));
            }
        }
    }

    static void initArray() {
        sight = new boolean[N];
        dist = new long[N];
        Arrays.fill(dist, INF);
        adj = new List[N];
        for (int i = 0; i < N; ++i) {
            adj[i] = new ArrayList<>();
        }
    }
}