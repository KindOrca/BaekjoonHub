import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static List<Integer> A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        solve(0, 0);
        System.out.println(max);
    }

    static void solve(int K, int val) {
        if (K == N - 2) {
            max = Math.max(max, val);
            return;
        }
        for (int i = 1; i < A.size() - 1; ++i) {
            int temp = A.remove(i);
            solve(K + 1, val + A.get(i - 1) * A.get(i));
            A.add(i, temp);
        }
    }
}