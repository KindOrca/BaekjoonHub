import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqMax = new PriorityQueue<>();
        while (N-- > 0) {
            int q = Integer.parseInt(br.readLine());
            if (pqMin.size() == pqMax.size()) {
                pqMin.add(q);
                pqMax.add(pqMin.poll());
                sb.append(pqMax.peek());
            } else {
                pqMax.add(q);
                pqMin.add(pqMax.poll());
                sb.append(pqMin.peek());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}