import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[W];
        for (int i = 0; i < W; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0, tmp, start;
        for (int i = 1; i <= H; ++i) {
            tmp = 0; start = 0;
            while (start < W && A[start++] < i) {}
            for (int j = start; j < W; ++j) {
                if (A[j] < i) tmp++;
                else {
                    cnt += tmp;
                    tmp = 0;
                }
            }
        }
        System.out.println(cnt);
    }
}