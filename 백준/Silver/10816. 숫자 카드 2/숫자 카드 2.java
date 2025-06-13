import java.io.*;
import java.util.*;

public class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; ++i) {
            int q = Integer.parseInt(st.nextToken());
            sb.append(upperBound(q) - lowerBound(q)).append(" ");
        }
        System.out.println(sb);
    }

    static int lowerBound(int target) {
        int lo = 0, hi = A.length, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (A[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    static int upperBound(int target) {
        int lo = 0, hi = A.length, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (A[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}