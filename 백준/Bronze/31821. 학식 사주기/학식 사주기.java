import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] A = new int [N + 1];
        int ans = 0;
        for (int i = 1; i < N + 1; ++i) {
            A[i] = Integer.parseInt(br.readLine());
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; ++i) {
            ans += A[Integer.parseInt(br.readLine())];
        }
        System.out.println(ans);
    }
}