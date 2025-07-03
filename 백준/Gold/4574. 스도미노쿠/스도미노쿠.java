import java.io.*;
import java.util.*;

public class Main {
    static boolean flag;
    static int[][] map;
    static Map<String, Boolean> tile;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            sb.append("Puzzle ").append(T++).append("\n");
            initArray();
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int U = Integer.parseInt(st.nextToken());
                String LU = st.nextToken();
                int V = Integer.parseInt(st.nextToken());
                String LV = st.nextToken();
                map[LU.charAt(0) - 'A' + 1][LU.charAt(1) - '0'] = U;
                map[LV.charAt(0) - 'A' + 1][LV.charAt(1) - '0'] = V;
                int max = Math.max(U, V);
                int min = Math.min(U, V);
                tile.remove(min + "" + max);
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i < 10; ++i) {
                String s = st.nextToken();
                map[s.charAt(0) - 'A' + 1][s.charAt(1) - '0'] = i;
            }
            solve(1, 1);
        }
        System.out.println(sb);
    }

    static void solve(int x, int y) {
        if (flag) return;
        if (x == 9 && y == 9) {
            for (int i = 1; i < 10; ++i) {
                for (int j = 1; j < 10; ++j) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            flag = true;
            return;
        }
        if (x == 10) {
            solve(1, y + 1);
            return;
        }
        if (map[y][x] != 0) {
            solve(x + 1, y);
            return;
        }
        if (!(x != 9 && map[y][x + 1] == 0) && !(y != 9 && map[y + 1][x] == 0)) return;
        for (String s : tile.keySet()) {
            if (tile.get(s)) continue;
            tile.put(s, true);
            int L = s.charAt(0) - '0';
            int R = s.charAt(1) - '0';
            if (x != 9 && map[y][x + 1] == 0) {
                if (check(x, y, L) && check(x + 1, y, R)) {
                    map[y][x] = L;
                    map[y][x + 1] = R;
                    solve(x + 1, y);
                    map[y][x] = 0;
                    map[y][x + 1] = 0;
                }
                if (check(x, y, R) && check(x + 1, y, L)) {
                    map[y][x] = R;
                    map[y][x + 1] = L;
                    solve(x + 1, y);
                    map[y][x] = 0;
                    map[y][x + 1] = 0;
                }
            }
            if (y != 9 && map[y + 1][x] == 0) {
                if (check(x, y, L) && check(x, y + 1, R)) {
                    map[y][x] = L;
                    map[y + 1][x] = R;
                    solve(x + 1, y);
                    map[y][x] = 0;
                    map[y + 1][x] = 0;
                }
                if (check(x, y, R) && check(x, y + 1, L)) {
                    map[y][x] = R;
                    map[y + 1][x] = L;
                    solve(x + 1, y);
                    map[y][x] = 0;
                    map[y + 1][x] = 0;
                }
            }
            tile.put(s, false);
        }
    }

    static boolean check(int x, int y, int val) {
        for (int i = 1; i < 10; ++i) {
            if (map[y][i] == val) return false;
        }
        for (int i = 1; i < 10; ++i) {
            if (map[i][x] == val) return false;
        }
        int set_X = ((x - 1) / 3) * 3 + 1;
        int set_Y = ((y - 1) / 3) * 3 + 1;
        for (int i = set_Y; i < set_Y + 3; ++i) {
            for (int j = set_X; j < set_X + 3; ++j) {
                if (map[i][j] == val) return false;
            }
        }
        return true;
    }

    static void initArray() {
        flag = false;
        map = new int[11][11];
        tile = new HashMap<>();
        for (int i = 1; i < 9; ++i) {
            for (int j = i + 1; j < 10; ++j) {
                tile.put(i + "" + j, false);
            }
        }
    }
}