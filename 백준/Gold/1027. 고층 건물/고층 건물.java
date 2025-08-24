import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N];
        for (int i = 0; i < N; ++i) A[i] = Integer.parseInt(st.nextToken());
        int[] cnt = new int[N];
        for (int i = 0; i < N; ++i) {
            int le = 0, ri = 0;
            double pivot = 9876543210D;
            for (int j = i - 1; j > -1; --j) {
                double d = (double) (A[i] - A[j]) / (i - j);
                if (pivot > d) {
                    pivot = d;
                    le++;
                }
            }
            pivot = -9876543210D;
            for (int j = i + 1; j < N; ++j) {
                double d = (double) (A[j] - A[i]) / (j - i);
                if (pivot < d) {
                    pivot = d;
                    ri++;
                }
            }
            cnt[i] = le + ri;
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            if (cnt[i] > max) max = cnt[i];
        }
        System.out.println(max);
    }
}