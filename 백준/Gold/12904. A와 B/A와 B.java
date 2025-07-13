import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        while (T.length() != S.length()) {
            int l = T.length();
            char c = T.charAt(l - 1);
            T = T.substring(0, l - 1);
            if (c == 'B') {
                StringBuilder sb = new StringBuilder(T);
                T = sb.reverse().toString();
            }
        }
        System.out.println(S.equals(T) ? 1 : 0);
    }
}