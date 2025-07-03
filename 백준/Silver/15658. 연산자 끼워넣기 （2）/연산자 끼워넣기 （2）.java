import java.io.*;
import java.util.*;

public class Main {
    static int N, max, min;
    static int[] A, oper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        initArray();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; ++i) {
            oper[i] = Integer.parseInt(st.nextToken());
        }
        solve(1, A[0]);
        System.out.println(max + "\n" + min);
    }

    static void solve(int K, int val) {
        if (K == N) {
            max = Math.max(max, val);
            min = Math.min(min, val);
            return;
        }
        int temp;
        for (int i = 0; i < 4; ++i) {
            if (oper[i] == 0) continue;
            oper[i]--;
            if (i == 0) temp = val + A[K];
            else if (i == 1) temp = val - A[K];
            else if (i == 2) temp = val * A[K];
            else temp = val / A[K];
            solve(K + 1, temp);
            oper[i]++;
        }
    }

    static void initArray() {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        A = new int[N];
        oper = new int[4];
    }
}