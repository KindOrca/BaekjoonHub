import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pqMin;
    static PriorityQueue<Integer> pqMax;
    static int mid;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            int M = Integer.parseInt(br.readLine());
            initArray();
            for (int i = 0; i < M / 10; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 10; ++j) {
                    int N = Integer.parseInt(st.nextToken());
                    list.add(N);
                }
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M % 10; ++i) {
                int N = Integer.parseInt(st.nextToken());
                list.add(N);
            }
            mid = list.get(0);
            sb.append(M / 2 + 1).append("\n");
            sb.append(mid).append(" ");
            for (int i = 1; i < M; i += 2) {
                if (i % 20 == 19) sb.append("\n");
                getMiddle(list.get(i), list.get(i + 1));
                sb.append(mid).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void getMiddle(int A, int B) {
        if (A < mid) pqMin.add(-A);
        else pqMax.add(A);

        if (B < mid) pqMin.add(-B);
        else pqMax.add(B);

        if (pqMin.size() > pqMax.size()) {
            pqMax.add(mid);
            mid = -pqMin.poll();
        } else if (pqMax.size() > pqMin.size()) {
            pqMin.add(-mid);
            mid = pqMax.poll();
        }
    }

    static void initArray() {
        list = new ArrayList<>();
        pqMin = new PriorityQueue<>();
        pqMax = new PriorityQueue<>();
    }
}