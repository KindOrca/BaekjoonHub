import java.io.*;
import java.util.*;

class Node {
    int B, cnt;
    long D;
    Node(int B, long D, int cnt) {
        this.B = B;
        this.D = D;
        this.cnt = cnt;
    }
}

public class Main {
    static int N, M, K;
    static long[][] dist;
    static List<Node>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            adj[A].add(new Node(B, D, 0));
            adj[B].add(new Node(A, D, 0));
        }
        dijkstra();
        long min = Long.MAX_VALUE;
        for (int i = 0; i < K + 1; ++i) {
            min = Math.min(min, dist[N][i]);
        }
        System.out.println(min);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((p1, p2) -> Long.compare(p1.D, p2.D));
        pq.add(new Node(1, 0, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.B][cur.cnt] < cur.D && cur.cnt != K && dist[cur.B][cur.cnt + 1] < cur.D) continue;
            for (Node next : adj[cur.B]) {
                if (dist[next.B][cur.cnt] > dist[cur.B][cur.cnt] + next.D) {
                    dist[next.B][cur.cnt] = dist[cur.B][cur.cnt] + next.D;
                    pq.add(new Node(next.B, dist[next.B][cur.cnt], cur.cnt));
                }
                if (cur.cnt < K && dist[next.B][cur.cnt + 1] > dist[cur.B][cur.cnt]) {
                    dist[next.B][cur.cnt + 1] = dist[cur.B][cur.cnt];
                    pq.add(new Node(next.B, dist[next.B][cur.cnt + 1], cur.cnt + 1));
                }
            }
        }
    }

    static void initArray() {
        dist = new long[N + 1][K + 1];
        for (int i = 0; i < dist.length; ++i) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        for (int i = 0; i < K + 1; ++i) dist[1][i] = 0;
        adj = new List[N + 1];
        for (int i = 0; i < N + 1; ++i) {
            adj[i] = new ArrayList<>();
        }
    }
}