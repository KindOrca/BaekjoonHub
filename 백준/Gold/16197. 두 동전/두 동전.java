import java.io.*;
import java.util.*;

class Coin {
    int x, y;
    public Coin(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, ans = 11;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        Coin c1 = new Coin(-1, -1);
        Coin c2 = new Coin(-1, -1);
        for (int i = 0; i < N; ++i) {
            String s = br.readLine();
            for (int j = 0; j < M; ++j) {
                map[i][j] = s.charAt(j);
                if (c1.x == -1 && map[i][j] == 'o') c1 = new Coin(j, i);
                if (c1.x != -1 && map[i][j] == 'o') c2 = new Coin(j, i);
            }
        }
        solve(1, c1, c2);
        System.out.println(ans == 11 ? -1 : ans);
    }

    static void solve(int n, Coin c1, Coin c2) {
        if (n == 11) return;
        int x1, y1, x2, y2;
        for (int i = 0; i < 4; ++i) {
            x1 = c1.x + dx[i];
            y1 = c1.y + dy[i];
            x2 = c2.x + dx[i];
            y2 = c2.y + dy[i];
            boolean b1 = (x1 < 0 || y1 < 0 || x1 >= M || y1 >= N);
            boolean b2 = (x2 < 0 || y2 < 0 || x2 >= M || y2 >= N);
            if (b1 && b2) continue;
            if (b1 || b2) {
                ans = Math.min(ans, n);
                return;
            }
            if (map[y1][x1] == '#') {
                x1 = c1.x;
                y1 = c1.y;
            }
            if (map[y2][x2] == '#') {
                x2 = c2.x;
                y2 = c2.y;
            }
            if (x1 == x2 && y1 == y2) continue;
            if (x1 == c1.x && y1 == c1.y && x2 == c2.x && y2 == c2.y) continue;
            solve(n + 1, new Coin(x1, y1), new Coin(x2, y2));
        }
    }
}