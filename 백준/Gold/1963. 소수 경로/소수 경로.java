import java.io.*;
import java.util.*;

class Node {
    int val, idx;
    public Node(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

public class Main {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        eratos();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(solve(A, B)).append("\n");
        }
        System.out.println(sb);
    }

    static String solve(int A, int B) {
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(A, 0));
        boolean[] visited = new boolean[10000];
        visited[A] = true;
        int[] arr = new int[4];
        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.val == B) return String.valueOf(cur.idx);
            String s = cur.val + "";
            arr[0] = s.charAt(0) - '0';
            arr[1] = s.charAt(1) - '0';
            arr[2] = s.charAt(2) - '0';
            arr[3] = s.charAt(3) - '0';
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 10; ++j) {
                    if (i == 0 && j == 0) continue;
                    arr[i] = j;
                    int newVal = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
                    if (visited[newVal] || !prime[newVal]) continue;
                    visited[newVal] = true;
                    que.add(new Node(newVal, cur.idx + 1));
                }
                arr[i] = s.charAt(i) - '0';
            }
        }
        return "Impossible";
    }

    static void eratos() {
        prime = new boolean[10000];
        Arrays.fill(prime, true);
        for (int i = 2; i * i < 10000; ++i) {
            if (!prime[i]) continue;
            for (int j = i * i; j < 10000; j += i) {
                prime[j] = false;
            }
        }
    }
}