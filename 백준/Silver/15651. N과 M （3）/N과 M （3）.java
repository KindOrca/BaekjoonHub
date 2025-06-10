import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        NM(0, new int[M]);
        System.out.println(sb);
    }

    static void NM(int K, int[] arr) {
        if (K == M) {
            for (int i : arr) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i < N + 1; ++i) {
            arr[K] = i;
            NM(K + 1, arr);
        }
    }
}