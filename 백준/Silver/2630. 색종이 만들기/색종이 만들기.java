import java.io.*;
import java.util.*;

public class Main {
    static int white, blue;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cntPaper(0, 0, N);
        sb.append(white).append("\n").append(blue);
        System.out.println(sb);
    }

    static void cntPaper(int x, int y, int k) {
        int pivot = map[y][x];
        boolean check = true;
        a:
        for (int i = x; i < x + k; ++i) {
            for (int j = y; j < y + k; ++j) {
                if (pivot != map[j][i]) {
                    check = false;
                    break a;
                }
            }
        }
        if (check) {
            if (pivot == 1) blue++;
            else white++;
        }
        else {
            cntPaper(x, y, k / 2);
            cntPaper(x, y + k / 2, k / 2);
            cntPaper(x + k / 2, y, k / 2);
            cntPaper(x + k / 2, y + k / 2, k / 2);
        }
    }
}