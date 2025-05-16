import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, D, cnt;

    public Point(int x, int y, int D, int cnt) {
        this.x = x;
        this.y = y;
        this.D = D;
        this.cnt = cnt;
    }
}

public class Main {
    static int N, M, K;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 0; i < N; ++i) {
            String s = br.readLine();
            for (int j = 0; j < M; ++j) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        int ans = BFS();
        if (N == 1 && M == 1) ans = 1;
        System.out.println(ans);
    }

    static int BFS() {
        Queue<Point> que = new ArrayDeque<>();
        que.add(new Point(0, 0, 1, 0));
        visited[0][0] = 0;
        Point cur;
        int nx, ny;
        while (!que.isEmpty()) {
            cur = que.poll();
            for (int i = 0; i < 4; ++i) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || M <= nx || N <= ny) continue;
                if (map[ny][nx] == 1) {
                    if (cur.cnt == K) continue;
                    if (visited[ny][nx] < cur.cnt) continue;
                    visited[ny][nx] = cur.cnt;
                    if (cur.D % 2 == 0) {
                        que.add(new Point(cur.x, cur.y, cur.D + 1, cur.cnt));
                    } else {
                        que.add(new Point(nx, ny, cur.D + 1, cur.cnt + 1));
                    }
                } else {
                    if (visited[ny][nx] <= cur.cnt) continue;
                    visited[ny][nx] = cur.cnt;
                    que.add(new Point(nx, ny, cur.D + 1, cur.cnt));
                    if (nx == M - 1 && ny == N - 1) return cur.D + 1;
                }
            }
        }
        return -1;
    }

    static void initArray() {
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
    }
}