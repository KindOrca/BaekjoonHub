import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 9; ++i) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 9; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0, 0);
    }

    static void sudoku(int x, int y) {
        if (x == 9 && y == 8) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        if (x == 9) {
            sudoku(0, y + 1);
            return;
        }
        if (map[y][x] == 0) {
            for (int i = 1; i < 10; ++i) {
                if (check(x, y, i)) continue;
                map[y][x] = i;
                sudoku(x + 1, y);
                map[y][x] = 0;
            }
        } else {
            sudoku(x + 1, y);
        }
    }

    static boolean check(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (map[y][i] == val) return true;
        }
        for (int i = 0; i < 9; ++i) {
            if (map[i][x] == val) return true;
        }
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; ++i) {
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; ++j) {
                if (map[j][i] == val) return true;
            }
        }
        return false;
    }
}