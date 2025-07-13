import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] cache = new int[100001];
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            cache[A] = Math.max(cache[A], B);
            for (int i = A + 1; i < 100001; ++i) {
                cache[i] = Math.max(cache[i], cache[i - A] + B);
                if (cache[i] >= C) break;
            }
        }
        for (int i = 0; i < 100001; ++i) {
            if (cache[i] >= C) {
                System.out.println(i);
                break;
            }
        }
    }
}