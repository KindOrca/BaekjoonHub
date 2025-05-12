import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; ++i) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long ans;
            if (N == 1) ans = 0;
            else {
                ans = pq.poll() + pq.poll();
                long val = ans;
                for (int i = 0; i < N - 2; ++i) {
                    pq.add(val);
                    val = pq.poll() + pq.poll();
                    ans += val;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}