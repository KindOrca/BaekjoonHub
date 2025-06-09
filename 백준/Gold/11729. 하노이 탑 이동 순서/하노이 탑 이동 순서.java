import java.io.*;

public class Main {
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        hanoi(1, 3, N);
        System.out.println(cnt);
        System.out.println(sb);
    }

    static void hanoi(int A, int B, int K) {
        if (K == 0) return;
        hanoi(A, 6 - A - B, K - 1);
        sb.append(A).append(" ").append(B).append("\n");
        cnt++;
        hanoi(6 - A - B, B, K - 1);
    }
}