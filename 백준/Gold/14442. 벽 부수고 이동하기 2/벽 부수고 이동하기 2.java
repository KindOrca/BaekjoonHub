import java.io.*;
import java.util.*;

class Node {
   int x, y, k, D;
   public Node(int x, int y, int k, int D) {
       this.x = x;
       this.y = y;
       this.k = k;
       this.D = D;
   }
}

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 1; i < N + 1; ++i) {
            String s = br.readLine();
            for (int j = 1; j < M + 1; ++j) {
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }
        System.out.println(solve());
    }

    static int solve() {
        if (N == 1 && M == 1) return 1;
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(1, 1, 0, 1));
        visited[0][1][1] = true;
        int nx, ny;
        while (!que.isEmpty()) {
            Node cur = que.poll();
            for (int i = 0; i < 4; ++i) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];
                if (nx < 1 || ny < 1 || nx >= M + 1 || ny >= N + 1) continue;
                if (visited[cur.k][ny][nx]) continue;
                visited[cur.k][ny][nx] = true;
                if (map[ny][nx] == 1 && cur.k == K) continue;
                if (map[ny][nx] == 1) {
                    visited[cur.k + 1][ny][nx] = true;
                    que.add(new Node(nx, ny, cur.k + 1, cur.D + 1));
                    continue;
                }
                if (ny == N && nx == M) return cur.D + 1;
                visited[cur.k][ny][nx] = true;
                que.add(new Node(nx, ny, cur.k, cur.D + 1));
            }
        }
        return -1;
    }

    static void initArray() {
        map = new int[N + 1][M + 1];
        visited = new boolean[K + 1][N + 1][M + 1];
    }
}