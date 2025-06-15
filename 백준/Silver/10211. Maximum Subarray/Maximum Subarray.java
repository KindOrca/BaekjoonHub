import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; ++i) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            int max = A[0], pSum1 = 0, pSum2 = 0;
            for (int i = 0; i < N; ++i) {
                pSum1 += A[i];
                max = Math.max(max, pSum1 - pSum2);
                pSum2 = Math.min(pSum1, pSum2);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}