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
    static List<Node>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        adj = new List[V + 1];
        for (int i = 1; i < V + 1; ++i) {
            adj[i] = new ArrayList<>();
        }
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adj[A].add(new Node(B, C));
            adj[B].add(new Node(A, C));
        }
        System.out.println(prim(1));
    }

    static int prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.D, b.D));
        boolean[] visited = new boolean[adj.length];
        int len = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.B]) continue;
            visited[cur.B] = true;
            len += cur.D;
            for (Node nxt : adj[cur.B]) {
                if (visited[nxt.B]) continue;
                pq.add(nxt);
            }
        }
        return len;
    }
}