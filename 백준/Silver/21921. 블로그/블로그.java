import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[X];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < X; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < N; ++i) {
            sum += A[i];
        }
        int max = sum, cnt = 1;
        for (int i = N ; i < X; ++i) {
        	sum += A[i] - A[i - N];
            if (sum > max) {
                max = sum;
                cnt = 1;
            } else if (sum == max) {
                cnt++;
            }
        }
        System.out.println(max == 0 ? "SAD" : max + "\n" + cnt);
    }
}