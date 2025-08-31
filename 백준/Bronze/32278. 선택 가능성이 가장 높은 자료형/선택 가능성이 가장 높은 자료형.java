import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        String s;
        if (-32768 <= N && N <= 32767) s = "short";
        else if (-2147483648 <= N && N <= 2147483647) s = "int";
        else s = "long long";
        System.out.println(s);
    }
}