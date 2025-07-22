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
    static int N, M, K, INF = 987564321;
    static int[] dist;
    static int[] friends;
    static List<Node>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            initArray();
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adj[a].add(new Node(b, c));
                adj[b].add(new Node(a, c));
            }
            K = Integer.parseInt(br.readLine());
            friends = new int[K];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < K; ++i) {
                friends[i] = Integer.parseInt(st.nextToken());
            }
            int min = INF, idx = N;
            for (int i = N; i > 0; --i) {
                int D = solve(i);
                if (min >= D) {
                    min = D;
                    idx = i;
                }
            }
            sb.append(idx).append("\n");
        }
        System.out.println(sb);
    }

    static int solve(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.D - n2.D);
        pq.add(new Node(start, 0));
        Arrays.fill(dist, INF);
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.B] < cur.D) continue;
            for (Node next : adj[cur.B]) {
                if (dist[next.B] > dist[cur.B] + next.D) {
                    dist[next.B] = dist[cur.B] + next.D;
                    pq.add(new Node(next.B, dist[next.B]));
                }
            }
        }
        int D = 0;
        for (int i : friends) D += dist[i];
        return D;
    }

    static void initArray() {
        dist = new int[N + 1];
        adj = new List[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adj[i] = new ArrayList<>();
        }
    }
}