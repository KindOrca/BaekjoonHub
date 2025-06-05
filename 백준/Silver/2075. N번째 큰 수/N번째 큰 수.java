import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                pq.add(-Integer.parseInt(st.nextToken()));
            }
        }
        while (N-- > 1) pq.poll();
        System.out.println(-pq.poll());
    }
}