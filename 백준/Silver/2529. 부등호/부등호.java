import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static String max, min;
    static char[] c;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        initArray();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; ++i) {
            c[i] = st.nextToken().charAt(0);
        }
        permutation(0, new int[k + 1]);
        System.out.println(max + "\n" + min);
    }

    static void permutation(int n, int[] arr) {
        if (n == k + 1) {
            solve(arr);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[n] = i;
            permutation(n + 1, arr);
            visited[i] = false;
        }
    }

    static void solve(int[] arr) {
        for (int i = 0; i < k; ++i) {
            if (c[i] == '<' && arr[i] >= arr[i + 1]) return;
            if (c[i] == '>' && arr[i] <= arr[i + 1]) return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) sb.append(i);
        long temp = Long.parseLong(sb.toString());
        max = Long.parseLong(max) > temp ? max : sb.toString();
        min = Long.parseLong(min) > temp ? sb.toString() : min;
    }

    static void initArray() {
        max = "0";
        min = "9999999999";
        c = new char[k];
        visited = new boolean[10];
    }
}