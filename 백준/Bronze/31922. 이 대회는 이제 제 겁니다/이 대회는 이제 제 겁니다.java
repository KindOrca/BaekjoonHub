import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(Math.max(A + C, P));
    }
}