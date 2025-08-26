import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) A[i] = Integer.parseInt(st.nextToken());
        int[] le = new int[N];
        int[] tails1 = new int[N];
        int len1 = 0;
        for (int i = 0; i < N; ++i) {
            int pos = lowerBound(tails1, len1, A[i]); // [0, len1) 에서 A[i] 들어갈 위치
            tails1[pos] = A[i];
            if (pos == len1) len1++;
            le[i] = pos + 1;
        }
        int[] ri = new int[N];
        int[] tails2 = new int[N];
        int len2 = 0;
        for (int i = N - 1; i >= 0; --i) {
            int val = -A[i];
            int pos = lowerBound(tails2, len2, val);
            tails2[pos] = val;
            if (pos == len2) len2++;
            ri[i] = pos + 1;
        }
        while (Q-- > 0) {
            int q = Integer.parseInt(br.readLine());
            sb.append(le[q - 1] + ri[q - 1] - 1).append("\n");
        }
        System.out.println(sb);
    }

    static int lowerBound(int[] arr, int end, int target) {
        int lo = 0, hi = end, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}