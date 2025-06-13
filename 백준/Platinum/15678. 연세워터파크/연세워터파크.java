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
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Node> deq = new ArrayDeque<>();
        // DEQUE DP
        deq.add(new Node(0, 0));
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < N; ++i) {
            while (!deq.isEmpty() && deq.peek().idx + D < i) deq.pollFirst();
            long cur = Math.max(A[i], A[i] + deq.peek().val);
            ans = Math.max(ans, cur);
            while (!deq.isEmpty() && deq.peekLast().val <= cur) deq.pollLast();
            deq.add(new Node(cur, i));
        }
        System.out.println(ans);
    }
}