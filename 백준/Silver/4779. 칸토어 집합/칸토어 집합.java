import java.io.*;
import java.util.*;

public class Main {
    static char[] c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N;
        while((N = br.readLine())!= null) {
            int n = (int) Math.pow(3, Integer.parseInt(N));
            c = new char[n];
            Arrays.fill(c, '-');
            cantor(0, n);
            sb.append(c);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void cantor(int a, int b) {
        if (b - a < 3) return;
        int k = (b - a) / 3;
        for (int i = a + k; i < b - k; ++i) {
            c[i] = ' ';
        }
        cantor(a, a + k);
        cantor(b - k, b);
    }
}