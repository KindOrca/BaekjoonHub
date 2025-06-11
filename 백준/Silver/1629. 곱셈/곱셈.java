import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(power(A, B, C));
    }

    static long power(int a, int b, int c) {
        if (b == 1) return a % c;
        long temp = power(a, b / 2, c);
        temp = (temp * temp) % c;
        if (b % 2 == 1) {
            return (temp * (a % c)) % c;
        } else {
            return temp;
        }
    }
}
