import java.util.*;

class Node {
    int x, y, k;
    String s;
    Node(int x, int y, int k) {
        this.x = x;
        this.y = y;
        this.k = k;
    }
}

class Solution {
    
    static int n, m, k;
    static int[][] map;
    static String[][] visited;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};
    static String[] dir;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
        initArray();
        BFS(y - 1, x - 1, c - 1, r - 1);
        String answer = visited[r - 1][c - 1];
        if (answer.isEmpty() || answer.length() != k) answer = "impossible";
        return answer;
    }
    
    static void BFS(int x, int y, int r, int c) {
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(x, y, 0));
        visited[y][x] = "";
        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.k == k) continue;
            for (int i = 0; i < 4; ++i) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                String tmp = visited[cur.y][cur.x] + dir[i];
                if (visited[ny][nx].isEmpty()) {
                    visited[ny][nx] = tmp;
                    que.add(new Node(nx, ny, cur.k + 1));
                } else if (visited[ny][nx].length() < visited[cur.y][cur.x].length() + 1) {
                    visited[ny][nx] = tmp;
                    que.add(new Node(nx, ny, cur.k + 1));
                } else {
                    if (visited[ny][nx].compareTo(tmp) <= 0) continue;
                    visited[ny][nx] = tmp;
                    que.add(new Node(nx, ny, cur.k + 1));
                }
            }
        }
    }
    
    static void initArray() {
        map = new int[n][m];
        visited = new String[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                visited[i][j] = "";
            }
        }
        dir = new String[] {"d", "l", "r", "u"};
    }
}