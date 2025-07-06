import java.io.*;
import java.util.*;

class Node {
    int x, y, preDir, cnt;
    public Node(int x, int y, int preDir, int cnt) {
        this.x = x;
        this.y = y;
        this.preDir = preDir;
        this.cnt = cnt;
    }
}

class Light {
    int x, y;
    public Light(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int W, H;
    static int[][] cnt;
    static char[][] map;
    static List<Light> lights;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 0; i < H; ++i) {
            String s = br.readLine();
            for (int j = 0; j < W; ++j) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'C') lights.add(new Light(j, i));
            }
        }
        solve();
        Light l = lights.get(1);
        System.out.println(cnt[l.y][l.x]);
    }

    static void solve() {
        int x = lights.get(0).x;
        int y = lights.get(0).y;
        Queue<Node> que = new ArrayDeque<>();
        cnt[y][x] = 0;
        int nx, ny;
        for (int i = 0; i < 4; ++i) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || nx >= W || ny < 0 || ny >= H) continue;
            if (map[ny][nx] == '*') continue;
            que.add(new Node(nx, ny, i, 0));
            cnt[ny][nx] = 0;
        }
        while (!que.isEmpty()) {
            Node cur = que.poll();
            for (int i = 0; i < 4; ++i) {
                if (i != cur.preDir && (i + cur.preDir) % 2 == 0) continue;
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                if (map[ny][nx] == '*') continue;
                if (i == cur.preDir) {
                    if (cnt[ny][nx] <= cur.cnt) continue;
                    cnt[ny][nx] = cur.cnt;
                    que.add(new Node(nx, ny, i, cur.cnt));
                } else {
                    if (cnt[ny][nx] < cur.cnt + 1) continue;
                    cnt[ny][nx] = cur.cnt + 1;
                    que.add(new Node(nx, ny, i, cur.cnt + 1));
                }
            }
        }
    }

    static void initArray() {
        cnt = new int[H][W];
        map = new char[H][W];
        lights = new ArrayList<>();
        for (int i = 0; i < H; ++i) {
            Arrays.fill(cnt[i], Integer.MAX_VALUE);
        }
    }
}