import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = new String[N];
        for (int i = 0; i < N; ++i) s[i] = br.readLine();
        a: while (N-- > 0) for (int i = 0; i < s[N].length(); ++i) if (s[N].charAt(i) == 'S') break a;
        System.out.println(s[N]);
    }
}