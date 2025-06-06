import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] idx;
    static List<Set<Integer>> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        initArray();
        for (int i = 1; i < N + 1; ++i) {
            idx[i] = i;
            st = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(st.nextToken());
            Set<Integer> s = new HashSet<>();
            while (K-- > 0) s.add(Integer.parseInt(st.nextToken()));
            set.add(s);
        }

        for (int i = 0; i < Q;++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            if (t == 1) {
                int b = Integer.parseInt(st.nextToken());
                int A = idx[a];
                int B = idx[b];
                if (set.get(A).size() < set.get(B).size()) {
                    int temp = A;
                    A = B;
                    B = temp;
                    idx[a] = A;
                    idx[b] = B;
                }
                set.get(A).addAll(set.get(B));
                set.set(B, new HashSet<>());
            } else {
                sb.append(set.get(idx[a]).size()).append('\n');
            }
        }
        System.out.print(sb);
    }

    static void initArray() {
        idx = new int[N + 1];
        set = new ArrayList<>();
        set.add(new HashSet<>());
    }
}