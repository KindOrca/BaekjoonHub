import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int X = sc.nextInt();
        int N = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            int K = sc.nextInt();
            boolean check = false;
            for (int j = 0; j < K; ++j) {
                int c = sc.nextInt();
                if (c == X) {
                    check = true;
                }
            }
            if (check) {
                cnt++;
            }
        }
        System.out.println(cnt == N ? "YES" : "NO");
    }
}