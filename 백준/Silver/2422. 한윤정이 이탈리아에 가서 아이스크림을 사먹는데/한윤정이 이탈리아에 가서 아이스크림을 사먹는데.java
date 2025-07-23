import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt;
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        initArray();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[Math.min(A, B)].add(Math.max(A, B));
        }
        solve(0, 1, new int[3]);
        System.out.println(cnt);
    }

    static void solve(int K, int st, int[] arr) {
        if (K == 3) {
            if (check(arr)) return;
            cnt++;
            return;
        }
        for (int i = st; i < N + 1; ++i) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[K] = i;
            solve(K + 1, i + 1, arr);
            visited[i] = false;
        }
    }

    static boolean check(int[] arr) {
        for (int i : list[arr[0]])
            if (arr[1] == i || arr[2] == i) return true;
        for (int i : list[arr[1]])
            if (arr[2] == i) return true;
        return false;
    }

    static void initArray() {
        visited = new boolean[N + 1];
        list = new List[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            list[i] = new ArrayList<>();
        }
    }
}