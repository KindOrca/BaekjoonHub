import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) A[i] = Integer.parseInt(st.nextToken());
        int sum, cnt = 0;
        for (int i = 1; i < (1 << N); ++i) {
            sum = 0;
            for (int j = 0; j < N; ++j) {
                if ((i & (1 << j)) != 0) sum += A[j];
            }
            if (sum == S) cnt++;
        }
        System.out.println(cnt);
    }
}