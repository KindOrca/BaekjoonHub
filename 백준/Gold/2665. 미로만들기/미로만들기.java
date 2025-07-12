import java.io.*;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            String s = br.readLine();
            for (int j = 0; j < N; ++j) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(solve());
    }

    static int solve() {
        Deque<Point> deq = new ArrayDeque<>();
        deq.add(new Point(0, 0));
        int[][] visited = new int[N][N];
        for (int i = 0; i < N; ++i) Arrays.fill(visited[i], -1);
        visited[0][0] = 0;
        int nx, ny;
        while (!deq.isEmpty()) {
            Point p = deq.poll();
            if (p.x == N - 1 && p.y == N - 1) continue;
            for (int i = 0; i < 4; ++i) {
                nx = p.x + dx[i];
                ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[ny][nx] != -1) continue;
                if (map[ny][nx] == 0) {
                    visited[ny][nx] = visited[p.y][p.x] + 1;
                    deq.addLast(new Point(nx, ny));
                } else {
                    visited[ny][nx] = visited[p.y][p.x];
                    deq.addFirst(new Point(nx, ny));
                }
            }
        }
        return visited[N - 1][N - 1];
    }
}