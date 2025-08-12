import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (int i = 0; i < N; ++i) {
            char ch = str.charAt(i);
            if (ch == 'I') sb.append("i");
            else sb.append("L");
        }
        System.out.println(sb);
    }
}