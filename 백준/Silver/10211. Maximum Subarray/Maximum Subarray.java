import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            int[] pSum = new int[N + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; ++i) {
                A[i] = Integer.parseInt(st.nextToken());
                pSum[i + 1] = pSum[i] + A[i];
            }
            int max = A[0];
            for (int i = 0; i < N; ++i) {
                for (int j = i + 1; j < N + 1; ++j) {
                    max = Math.max(max, pSum[j] - pSum[i]);
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}