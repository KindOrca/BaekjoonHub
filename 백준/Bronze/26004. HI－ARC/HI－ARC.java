import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; ++i) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        int ans = Math.min(map.getOrDefault('H', 0), Math.min(map.getOrDefault('I', 0), Math.min(map.getOrDefault('A' ,0), Math.min(map.getOrDefault('R', 0), map.getOrDefault('C', 0)))));
        System.out.println(ans);
    }
}