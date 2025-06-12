import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static boolean[][] ladder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new boolean[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }
        for (int i = 0; i < 4; ++i) {
            if (solve(0, 1, i)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    static boolean solve(int idx, int x, int K) {
        if (idx == K) return check();
        for (int i = x; i < H + 1; ++i) {
            for (int j = 1; j < N; ++j) {
                if (ladder[i][j] || ladder[i][j - 1] || ladder[i][j + 1]) continue;
                ladder[i][j] = true;
                if (solve(idx + 1, i, K)) return true;
                ladder[i][j] = false;
            }
        }
        return false;
    }

    static boolean check() {
        for (int i = 1; i < N + 1; ++i) {
            int pos = i;
            for (int j = 1; j < H + 1; ++j) {
                if (ladder[j][pos]) pos++;
                else if (ladder[j][pos - 1]) pos--;
            }
            if (pos != i) return false;
        }
        return true;
    }
}