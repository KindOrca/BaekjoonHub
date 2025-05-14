import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long m = Long.parseLong(br.readLine());
        long n = Long.parseLong(br.readLine());
        long ans;
        if (m == 1) ans = n;
        else if (n == 1) ans = m;
        else ans = 2 * (m + n) - 4;
        System.out.println(ans);
    }
}