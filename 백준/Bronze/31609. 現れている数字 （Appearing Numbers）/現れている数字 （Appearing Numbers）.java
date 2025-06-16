import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (N-- > 0) set.add(Integer.parseInt(st.nextToken()));
        while (!set.isEmpty()) sb.append(set.pollFirst()).append("\n");
        System.out.println(sb);
    }
}