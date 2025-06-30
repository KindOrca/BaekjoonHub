import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] A = new String[N];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            A[i] = br.readLine();
            for (int j = 0; j < A[i].length(); ++j) {
                char c = A[i].charAt(j);
                map.put(c, map.getOrDefault(c, 0) + (int) Math.pow(10, A[i].length() - 1 - j));
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int max = 0;
        for (int i = 10 - list.size(); i < 10; ++i) {
            max += i * list.get(i - 10 + list.size());
        }
        System.out.println(max);
    }
}