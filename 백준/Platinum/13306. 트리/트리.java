import java.io.*;
import java.util.*;

class Quest {
    int x, A, B;
    Quest(int x) {
        this.x = x;
    }
}

public class Main {
    static int N;
    static int[] parent;
    static List<Quest> quests;
    static Map<Integer, Integer> getParent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 2; i < N + 1; ++i) {
            parent[i] = Integer.parseInt(br.readLine());
            getParent.put(i, parent[i]);
        }
        for (int i = 0; i < Q + N - 1; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            Quest q = new Quest(x);
            q.A = a;
            if (x == 0) parent[a] = a;
            else q.B = Integer.parseInt(st.nextToken());
            quests.add(q);
        }
        for (int i = Q + N - 2; i > -1; --i) {
            Quest q = quests.get(i);
            if (q.x == 0) union(getParent.get(q.A), q.A);
            else {
                if (find(q.A) != find(q.B)) sb.insert(0, "NO\n");
                else sb.insert(0, "YES\n");
            }
        }
        System.out.println(sb);
    }

    static int find(int N) {
        if (N == parent[N]) return N;
        return parent[N] = find(parent[N]);
    }

    static void union(int A, int B) {
        A = find(A);
        B = find(B);
        if (A == B) return;
        parent[B] = A;
    }

    static void initArray() {
        parent = new int[N + 1];
        quests = new ArrayList<>();
        getParent = new HashMap<>();
    }
}