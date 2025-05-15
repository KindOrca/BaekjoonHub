import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sum = -8;
        while (N-- > 0) sum += Integer.parseInt(st.nextToken()) + 8;
        System.out.println(sum / 24 + " " + sum % 24);
    }
}