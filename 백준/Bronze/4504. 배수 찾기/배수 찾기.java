import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (true) {
            int q = Integer.parseInt(br.readLine());
            if (q == 0) break;
            sb.append(q);
            if (q % n == 0) sb.append(" is a multiple of ");
            else sb.append(" is NOT a multiple of ");
            sb.append(n).append(".\n");
        }
        System.out.println(sb);
    }
}