import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        matrix = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        int[][] ans = power(B);
        for (int[] a : ans) {
            for (int i : a) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[][] power(long K) {
        if (K == 1) return matrix;
        int[][] temp = power(K / 2);
        if (K % 2 == 0) {
            return calc(temp, temp);
        } else {
            return calc(calc(temp, temp), matrix);
        }
    }

    static int[][] calc(int[][] A, int[][] B) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < N; ++k) {
                    temp[i][j] += A[i][k] * B[k][j];
                }
                temp[i][j] = temp[i][j] % 1000;
            }
        }
        return temp;
    }
}