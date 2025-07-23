import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cnt;
    static int[][] map, cache;
    static boolean[][] visited;
    static Map<Integer, Integer> count;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int idx = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (map[i][j] == 0 || visited[i][j]) continue;
                visited[i][j] = true;
                cnt = 0;
                cache[i][j] = ++idx;
                dfs(j, i, idx);
                count.put(idx, cnt);
            }
        }
        Set<Integer> set = new HashSet<>();
        int sum, max = 0, x, y;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (map[i][j] == 1) continue;
                sum = 1;
                for (int k = 0; k < 4; ++k) {
                    x = j + dx[k];
                    y = i + dy[k];
                    if (x < 0 || y < 0 || x >= M || y >= N) continue;
                    if (cache[y][x] == 0) continue;
                    set.add(cache[y][x]);
                }
                for (int n : set) sum += count.get(n);
                max = Math.max(max, sum);
                set.clear();
            }
        }
        System.out.println(max == N * M + 1 ? N * M - 1 : max);
    }

    static void dfs(int x, int y, int val) {
        cnt++;
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if (map[ny][nx] == 0 || visited[ny][nx]) continue;
            visited[ny][nx] = true;
            cache[ny][nx] = val;
            dfs(nx, ny, val);
        }
    }

    static void initArray() {
        map = new int[N][M];
        cache = new int[N][M];
        visited = new boolean[N][M];
        count = new HashMap<>();
    }
}