import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < N; ++i) {
            while (!deq.isEmpty() && A[deq.peekLast()] > A[i]) deq.pollLast();
            deq.add(i);
            if (deq.peekFirst() <= i - L) deq.pollFirst();
            sb.append(A[deq.peekFirst()]).append(" ");
        }
        System.out.println(sb);
    }
}