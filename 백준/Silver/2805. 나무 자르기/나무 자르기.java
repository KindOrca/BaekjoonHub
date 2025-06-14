import java.io.*;
import java.util.*;

public class Main {
    static long max;
    static long[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        A = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            A[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, A[i]);
        }
        System.out.println(upperBound(M) - 1);
    }

    static long upperBound(long target) {
        long lo = 0, hi = max + 1, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (check(mid, target)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    static boolean check(long len, long target) {
        long cnt = 0;
        for (long i : A) cnt += Math.max(i - len, 0);
        return cnt >= target;
    }
}