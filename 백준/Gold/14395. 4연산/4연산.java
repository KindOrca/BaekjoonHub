import java.io.*;
import java.util.*;

class Node {
    long i;
    String s;
    public Node(long i, String s) {
        this.i = i;
        this.s = s;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        System.out.println(solve(s, t));
    }

    static String solve(long s, int t) {
        if (s == t) return "0";
        Queue<Node> que = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();
        que.add(new Node(s, ""));
        visited.add(s);
        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.i == t) return cur.s;
            long next = cur.i * cur.i;
            if (!visited.contains(next) && next <= 1_000_000_000L) {
                visited.add(next);
                que.add(new Node(next, cur.s + "*"));
            }
            next = cur.i + cur.i;
            if (!visited.contains(next) && next <= 1_000_000_000L) {
                visited.add(next);
                que.add(new Node(next, cur.s + "+"));
            }
            next = 0;
            if (!visited.contains(next)) {
                visited.add(next);
                que.add(new Node(next, cur.s + "-"));
            }
            if (cur.i != 0) {
                next = 1;
                if (!visited.contains(next)) {
                    visited.add(next);
                    que.add(new Node(next, cur.s + "/"));
                }
            }
        }
        return "-1";
    }
}