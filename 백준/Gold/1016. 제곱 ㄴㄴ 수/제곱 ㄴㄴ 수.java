import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int sqr = (int) Math.sqrt(M);
        boolean[] prime = new boolean[sqr + 1];
        Deque<Integer> deq = new ArrayDeque<>();
        boolean[] check = new boolean[(int) (M - N + 1)];
        for (int i = 1; i < sqr + 1; i++) {
            prime[i] = true;
        }
        for (int i = 2; i < sqr + 1; ++i) {
            if (prime[i]) {
                deq.addLast(i);
                for (int j = i + i; j < sqr + 1; j += i) {
                    prime[j] = false;
                }
            }
        }
        long cur, mod, num;
        while (!deq.isEmpty()) {
            cur = deq.pollFirst();
            mod = N % (cur * cur);
            num = N;
            if (mod != 0)
                num = N - mod + (cur * cur);
            for (long i = num; i < M + 1; i += (cur * cur)) {
                check[(int) (i - N)] = true;
            }
        }
        int cnt = 0;
        for (boolean b : check) {
            if (!b) cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}