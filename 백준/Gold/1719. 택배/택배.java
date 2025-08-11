import java.io.*;
import java.util.*;

class Node {
    int B, cost, sec;
    Node(int B, int cost, int sec) {
        this.B = B;
        this.cost = cost;
        this.sec = sec;
    }
}

public class Main {
    static int n, INF = 987654321;
    static int[][] map;
    static List<Node>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        initArray();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            adj[A].add(new Node(B, D, 0));
            adj[B].add(new Node(A, D, 0));
        }
        for (int i = 1; i < n + 1; ++i) dijkstra(i);
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (i == j) sb.append("-");
                else sb.append(map[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Node(start, 0, 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.B] < cur.cost) continue;
            for (Node next : adj[cur.B]) {
                if (dist[next.B] > dist[cur.B] + next.cost) {
                    dist[next.B] = dist[cur.B] + next.cost;
                    if (cur.sec == 0) {
                        map[start][next.B] = next.B;
                        pq.add(new Node(next.B, dist[next.B], next.B));
                    } else {
                        map[start][next.B] = cur.sec;
                        pq.add(new Node(next.B, dist[next.B], cur.sec));
                    }
                }
            }
        }

    }

    static void initArray() {
        adj = new List[n + 1];
        map = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; ++i) {
            adj[i] = new ArrayList<>();
        }
    }
}