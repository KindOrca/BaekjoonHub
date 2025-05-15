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
    static int N, M, cnt;
    static char[][] map;
    static boolean[][] visited;
    static Map<Character, List<Point>> room;
    static Map<Character, Boolean> selected;
    static List<Point> start;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            initArray();
            for (int i = 0; i < N; ++i) {
                map[i] = br.readLine().toCharArray();
            }
            String s = br.readLine();
            for (int i = 0; i < s.length(); ++i) {
                selected.put((char) (s.charAt(i) - 32), true);
            }
            findStart();
            BFS();
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void findStart() {
        for (int i = 0; i < N; ++i) {
            if (map[i][0] == '.') start.add(new Point(0, i));
            if (map[i][M - 1] == '.') start.add(new Point(M - 1, i));
            if (map[i][0] == '$') {
                cnt++;
                start.add(new Point(0, i));
            }
            if (map[i][M - 1] == '$') {
                cnt++;
                start.add(new Point(M - 1, i));
            }
            if ('a' <= map[i][0]) {
                selected.put((char)(map[i][0] - 32), true);
                start.add(new Point(0, i));
            }
            if ('a' <= map[i][M - 1]) {
                selected.put((char)(map[i][M - 1] - 32), true);
                start.add(new Point(M - 1, i));
            }
        }
        for (int i = 1; i < M - 1; ++i) {
            if (map[0][i] == '.') start.add(new Point(i, 0));
            if (map[N - 1][i] == '.') start.add(new Point(i, N - 1));
            if (map[0][i] == '$') {
                cnt++;
                start.add(new Point(i, 0));
            }
            if (map[N - 1][i] == '$') {
                cnt++;
                start.add(new Point(i, N - 1));
            }
            if ('a' <= map[0][i]) {
                selected.put((char)(map[0][i] - 32), true);
                start.add(new Point(i, 0));
            }
            if ('a' <= map[N - 1][i]) {
                selected.put((char) (map[N - 1][i] - 32), true);
                start.add(new Point(i, N - 1));
            }
        }
        for (int i = 0; i < N; ++i) {
            if (65 <= map[i][0] && map[i][0] <= 90) {
                room.get(map[i][0]).add(new Point(0, i));
                if (selected.get(map[i][0]))start.add(new Point(0, i));
            }
            if (65 <= map[i][M - 1] && map[i][M - 1] <= 90) {
                room.get(map[i][M - 1]).add(new Point(M - 1, i));
                if (selected.get(map[i][M - 1])) start.add(new Point(M - 1, i));
            }
        }
        for (int i = 1; i < M - 1; ++i) {
            if (65 <= map[0][i] && map[0][i] <= 90) {
                room.get(map[0][i]).add(new Point(i, 0));
                if (selected.get(map[0][i])) start.add(new Point(i, 0));
            }
            if (65 <= map[N - 1][i] && map[N - 1][i] <= 90) {
                room.get(map[N - 1][i]).add(new Point(i, N - 1));
                if (selected.get(map[N - 1][i])) start.add(new Point(i, N - 1));
            }
        }
    }

    static void BFS() {
        Queue<Point> que = new ArrayDeque<>();
        visited = new boolean[N][M];
        for (Point point : start) {
            que.add(point);
            visited[point.y][point.x] = true;
        }
        Point cur;
        while (!que.isEmpty()) {
            cur = que.poll();
            int nx, ny;
            for (int i = 0; i < 4; ++i) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || N <= ny || M <= nx) continue;
                if (map[ny][nx] == '*') continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                if (map[ny][nx] != '.'&& 65 <= map[ny][nx] && map[ny][nx] <= 90) {
                    if (!selected.get(map[ny][nx])) {
                        room.get(map[ny][nx]).add(new Point(nx, ny));
                        continue;
                    }
                }
                if (map[ny][nx] != '.' && 'a' <= map[ny][nx]) {
                    selected.put((char)(map[ny][nx] - 32), true);
                    que.addAll(room.get((char)(map[ny][nx] - 32)));
                }
                que.add(new Point(nx, ny));
                if (map[ny][nx] == '$') cnt++;
            }
        }
    }

    static void initArray() {
        cnt = 0;
        map = new char[N][M];
        room = new HashMap<>();
        selected = new HashMap<>();
        start = new ArrayList<>();
        char A = 'A';
        for (int i = 0; i < 26; ++i) {
            room.put((char)(A + i), new ArrayList<>());
            selected.put((char)(A + i), false);
        }
    }
}