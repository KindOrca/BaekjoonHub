import java.io.*;
import java.util.*;

class Quest {
    int X, a;
    Quest(int X, int a) {
        this.X = X;
        this.a = a;
    }
}

public class Main {
    static int N;
    static int[] parent, rank;
    static List<Quest> quests;
    static List<Set<Integer>> colors;
    static Map<Integer, Integer> getParent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 2; i < N + 1; ++i) {
            parent[i] = Integer.parseInt(br.readLine());
            getParent.put(i, parent[i]);
        }
        for (int i = 1; i < N + 1; ++i) {
            colors.get(i).add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < N + Q - 1; ++i) {
            st = new StringTokenizer(br.readLine()," ");
            int X = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            quests.add(new Quest(X, a));
            if (X == 1) parent[a] = a;
        }
        parent[1] = 1;
        for (int i = 1; i < N + 1; ++i) {
            if (i == parent[i]) continue;
            union(i, parent[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = N + Q - 2; i > - 1; --i) {
            Quest q = quests.get(i);
            if (q.X == 1) union(q.a, getParent.get(q.a));
            else ans.add(colors.get(find(q.a)).size());
        }
        for (int i = Q - 1; i > - 1; --i) {
            sb.append(ans.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    static int find(int A) {
        if (A == parent[A]) return A;
        return parent[A] = find(parent[A]);
    }

    static void union(int A, int B) {
        A = find(A);
        B = find(B);
        if (A == B) return;
        if (rank[A] > rank[B]) {
            int temp = A;
            A = B;
            B = temp;
        }
        colors.get(B).addAll(colors.get(A));
        parent[A] = B;
        if (rank[A] == rank[B]) rank[B]++;
    }

    static void initArray() {
        rank = new int[N + 1];
        parent = new int[N + 1];
        quests = new ArrayList<>();
        colors = new ArrayList<>();
        for (int i = 0; i < N + 1; ++i) {
            colors.add(new HashSet<>());
        }
        getParent = new HashMap<>();
    }
}
