import java.io.*;
import java.util.*;

class Node {
    int A, type;
    public Node(int A, int type) {
        this.A = A;
        this.type = type;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.A - n2.A);
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, 1));
            pq.add(new Node(b, -1));
        }
        int max = 0, ansLo = 0, ansHi = 0;
        int curCnt = 0;
        Node cur;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            int cnt = cur.type;
            while (!pq.isEmpty() && cur.A == pq.peek().A) {
                cnt += pq.poll().type;
            }
            if (cnt == 0) continue;
            curCnt += cnt;
            if (max < curCnt && cur.type == 1) {
                ansLo = cur.A;
            }
            if (max < curCnt - cnt && cur.type == -1) {
                max = curCnt - cnt;
                ansHi = cur.A;
            }
        }
        System.out.println(max);
        System.out.println(ansLo + " " + ansHi);
    }
}