import java.io.*;
import java.util.*;

class Node {
    int B, D;
    Node(int B, int D) {
        this.B = B;
        this.D = D;
    }
}

public class Main {
    static int n, k;
    static PriorityQueue<Integer>[] dist;
    static List<Node>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        initArray();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
        }
        dijkstra();
        for (int i = 1; i < n + 1; ++i) {
            if (dist[i].size() < k) sb.append(-1);
            else sb.append(dist[i].peek());
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.D, b.D));
        pq.add(new Node(1, 0));
        dist[1].add(0);
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : adj[cur.B]) {
                if (dist[next.B].size() < k) {
                    dist[next.B].add(cur.D + next.D);
                    pq.add(new Node(next.B, cur.D + next.D));
                    continue;
                }
                if (dist[next.B].peek() < cur.D + next.D) continue;
                dist[next.B].poll();
                dist[next.B].add(cur.D + next.D);
                pq.add(new Node(next.B, cur.D + next.D));
            }
        }
    }

    static void initArray() {
        adj = new List[n + 1];
        for (int i = 1; i < n + 1; ++i) adj[i] = new ArrayList<>();
        dist = new PriorityQueue[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            dist[i] = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        }
    }
}