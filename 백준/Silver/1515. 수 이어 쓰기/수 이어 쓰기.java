import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int i = 0;
        a: while (true) {
            String t = String.valueOf(++i);
            for (int j = 0; j < t.length(); ++j) {
                if (t.charAt(j) == s.charAt(0)) {
                	s = s.substring(1);
                	if (s.isEmpty()) break a;
                }
            }
        }
        System.out.println(i);
    }
}