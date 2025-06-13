import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long max;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        A = new int[K];
        for (int i = 0; i < K; ++i) {
            A[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, A[i]);
        }
        System.out.println(upperBound(N) - 1);
    }

    static int upperBound(int target) {
        long lo = 0, hi = max + 1, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (cut((int) mid) < target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return (int) lo;
    }

    static int cut(int N) {
        int cnt = 0;
        for (int i : A) cnt += i / N;
        return cnt;
    }
}