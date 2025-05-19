import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Set<Character> s = new HashSet<>();
        s.add('w'); s.add('b'); s.add('g');
        char c = '0';
        a: for (int i = 0; i < 15; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 15; ++j) {
                c = st.nextToken().charAt(0);
                if (s.contains(c)) break a;
            }
        }
        String a ="";
        if (c == 'w') a = "chunbae";
        if (c == 'b') a = "nabi";
        if (c == 'g') a = "yeongcheol";
        System.out.println(a);
    }
}