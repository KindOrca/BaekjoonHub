import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int a = s.length();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ':') a++;
            else if (c == '_') a += 5;
        }
        System.out.println(a);
    }
}