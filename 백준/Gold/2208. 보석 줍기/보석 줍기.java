import java.io.*;
import java.util.*;

public class Main {
    static int[] A, pSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new int[N];
        pSum = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(br.readLine());
            pSum[i + 1] = pSum[i] + A[i];
        }
        int max = 0, sum = 0;
        for (int i = M - 1; i < N; ++i) {
            sum = Math.min(sum, pSum[i - M + 1]);
            max = Math.max(max, pSum[i + 1] - sum);
        }
        System.out.println(max);
    }
}