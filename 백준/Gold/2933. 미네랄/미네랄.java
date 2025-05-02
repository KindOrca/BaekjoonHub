import java.io.*;
import java.util.*;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; ++i) {
            map[i] = br.readLine().toCharArray();
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        boolean dir = true;
        for (int i = 0; i < N; ++i) {
            int height = Integer.parseInt(st.nextToken());
            throwStick(R - height, dir);
            dir = !dir;
        }
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void throwStick(int height, boolean dir) {
        if (dir) {
            for (int i = 0; i < C; ++i) {
                if (map[height][i] == 'x') {
                    map[height][i] = '.';
                    find(new Point(i, height));
                    break;
                }
            }
        } else {
            for (int i = C - 1; i > -1; --i) {
                if (map[height][i] == 'x') {
                    map[height][i] = '.';
                    find(new Point(i, height));
                    break;
                }
            }
        }
    }

    static void find(Point p) {
        int nx, ny;
        List<List<Point>> list = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            nx = p.x + dx[i];
            ny = p.y + dy[i];
            if (nx < 0 || ny < 0 || C <= nx || R <= ny) continue;
            if (map[ny][nx] == '.') continue;
            move(check(new Point(nx, ny)));
        }
    }

    static void move(List<Point> points) {
        if (points.isEmpty()) return;
        for (Point p : points) map[p.y][p.x] = '.';
        boolean check = true;
        while (check) {
            for (Point p : points) {
                if (p.y == R - 1 || map[p.y + 1][p.x] == 'x') {
                    check = false;
                    break;
                }
            }
            if (check) for (Point p : points) p.y++;
        }
        for (Point p : points) map[p.y][p.x] = 'x';
    }

    static List<Point> check(Point p) {
        int nx, ny;
        List<Point> list = new ArrayList<>();
        list.add(p);
        Queue<Point> que = new ArrayDeque<>();
        que.add(p);
        boolean[][] visited = new boolean[R][C];
        visited[p.y][p.x] = true;
        while (!que.isEmpty()) {
            p = que.poll();
            for (int i = 0; i < 4; ++i) {
                nx = p.x + dx[i];
                ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || C <= nx || R <= ny) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                if (map[ny][nx] == '.') continue;
                if (ny == R - 1) return new ArrayList<>();
                que.add(new Point(nx, ny));
                list.add(new Point(nx, ny));
            }
        }
        return list;
    }
}