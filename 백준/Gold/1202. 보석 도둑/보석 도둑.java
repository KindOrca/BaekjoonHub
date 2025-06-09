import java.io.*;
import java.util.*;

class Jewel {
    int m, v;
    public Jewel(int m, int v) {
        this.m = m;
        this.v = v;
    }
}

public class Main {
    static PriorityQueue<Jewel> pqWeight = new PriorityQueue<>((j1, j2) -> j1.m - j2.m);
    static PriorityQueue<Jewel> pqCost = new PriorityQueue<>((j1, j2) -> j2.v - j1.v);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            pqWeight.add(new Jewel(M, V));
        }
        int[] C = new int[K];
        for (int i = 0; i < K; ++i) {
            C[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(C);
        long ans = 0;
        for (int i = 0; i < K; ++i) {
            while (!pqWeight.isEmpty() && pqWeight.peek().m <= C[i]) {
                pqCost.add(pqWeight.poll());
            }
            if (!pqCost.isEmpty()) ans += pqCost.poll().v;
        }
        System.out.println(ans);
    }
}