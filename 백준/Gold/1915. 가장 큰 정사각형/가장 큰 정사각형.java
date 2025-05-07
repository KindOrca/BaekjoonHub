import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 0; i < n; ++i) {
            String s = br.readLine();
            for (int j = 0; j < m; ++j) {
                map[i + 1][j + 1] = s.charAt(j) - '0';
                sum[i + 1][j + 1] += sum[i][j + 1] + sum[i + 1][j] + map[i + 1][j + 1] - sum[i][j];
            }
        }
        int l = Math.min(n, m) + 1;
        a:
        while (l-- > 0) {
            for (int i = l; i < n + 1; ++i) {
                for (int j = l; j < m + 1; ++j) {
                    if (solve(j, i, l)) break a;
                }
            }
        }
        System.out.println(l * l);
    }

    static boolean solve(int x, int y, int l) {
        int ret = sum[y][x] - sum[y - l][x] - sum[y][x - l] + sum[y - l][x - l];
        return ret == l*l;
    }

    static void initArray() {
        map = new int[n + 1][m + 1];
        sum = new int[n + 1][m + 1];
    }
}