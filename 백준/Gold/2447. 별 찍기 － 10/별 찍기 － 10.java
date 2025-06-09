import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; ++i) Arrays.fill(map[i], '*');
        asterisk(N, N, N / 3);
        for (char[] row : map) sb.append(row).append('\n');
        System.out.println(sb);
    }

    static void asterisk(int x, int y, int k) {
        if (k == 0) return;
        for (int i = x - 2 * k; i < x - k; ++i) {
            for (int j = y - 2 * k; j < y - k; ++j) {
                map[i][j] = ' ';
            }
        }
        asterisk(x - k * 2, y - k * 2, k / 3);
        asterisk(x - k * 2, y - k, k / 3);
        asterisk(x - k * 2, y , k / 3);
        asterisk(x - k, y - k * 2, k / 3);
        asterisk(x - k, y, k / 3);
        asterisk(x, y - k * 2, k / 3);
        asterisk(x, y - k, k / 3);
        asterisk(x, y, k / 3);
    }
}
