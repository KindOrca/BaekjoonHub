import java.io.*;
import java.util.*;

public class Main {
    static int N, K, M;
    static Map<Integer, Set<Integer>> hyperTube;
    static Map<Integer, Set<Integer>> nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < K; ++j) {
                int P = Integer.parseInt(st.nextToken());
                hyperTube.get(i).add(P);
                nodes.get(P).add(i);
            }
        }
        System.out.println(N == 1 ? 1 : BFS());
    }

    static int BFS() {
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visitedHyper = new boolean[M];
        boolean[] visitedNode = new boolean[N + 1];
        for (int i : nodes.get(1)) que.add(i);
        int idx = 1;
        while (!que.isEmpty()) {
            int sz = que.size();
            idx++;
            while (sz-- > 0) {
                int curHyper = que.poll();
                if (visitedHyper[curHyper]) continue;
                visitedHyper[curHyper] = true;
                for (int node : hyperTube.get(curHyper)) {
                    if (visitedNode[node]) continue;
                    visitedNode[node] = true;
                    if (node == N) return idx;
                    for (int hyper : nodes.get(node)) {
                        que.add(hyper);
                    }
                }
            }
        }
        return -1;
    }

    static void initArray() {
        hyperTube = new HashMap<>();
        nodes = new HashMap<>();
        for (int i = 0; i < M; ++i) hyperTube.put(i, new HashSet<>());
        for (int i = 0; i < N + 1; ++i) nodes.put(i, new HashSet<>());
    }
}