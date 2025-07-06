import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ans = Math.min(N / 2, M);
        if (N >= M * 2) K = K - (N - 2 * M);
        else K = K - (M - N / 2);
        if (K > 0) ans -= (K + 2) / 3;
        System.out.println(Math.max(0, ans));
    }
}