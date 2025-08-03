import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean l = false, k = false, p = false;
        for (int i = 0; i < 3; ++i) {
            char c = br.readLine().charAt(0);
            if (c == 'l') l = true;
            else if (c == 'k') k = true;
            else if (c == 'p') p = true;
        }
        System.out.println(l && k && p ? "GLOBAL" : "PONIX");
    }
}