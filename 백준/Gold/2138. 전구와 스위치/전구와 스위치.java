import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] B = new int[N + 1];
        int[] C = new int[N + 1];
        String s = br.readLine();
        for (int i = 0; i < N; ++i) {
            A[i] = s.charAt(i) - '0';
            B[i] = A[i];
        }
        s = br.readLine();
        for (int i = 0; i < N; ++i) C[i] = s.charAt(i) - '0';
        int cnt = 0;
        for (int i = 1; i < N; ++i) {
            if (A[i - 1] == C[i - 1]) continue;
            A[i] = 1 - A[i];
            A[i + 1] = 1 - A[i + 1];
            cnt++;
        }
        if (A[N - 1] != C[N - 1]) {
            cnt = 1;
            B[0] = 1 - B[0];
            B[1] = 1 - B[1];
            for (int i = 1; i < N; ++i) {
                if (B[i - 1] == C[i - 1]) continue;
                B[i] = 1 - B[i];
                B[i + 1] = 1 - B[i + 1];
                cnt++;
            }
            if (B[N - 1] != C[N - 1]) cnt = -1;
        }
        System.out.println(cnt);
    }
}
