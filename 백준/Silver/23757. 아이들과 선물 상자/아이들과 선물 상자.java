import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> box = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            box.add(-Integer.parseInt(st.nextToken()));
        }
        int[] A = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 1;
        for (int i = 0; i < M; ++i) {
            if (-box.peek() < A[i]) {
                ans = 0;
                break;
            }
            box.add(box.poll() + A[i]);
        }
        System.out.println(ans);
    }
}