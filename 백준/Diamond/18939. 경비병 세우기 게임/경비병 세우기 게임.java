import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            if (M < 2 * K) {
                sb.append("Yuto").append("\n");
            } else if ((N * M) % 2 == 1) {
                sb.append("Yuto").append("\n");
            } else {
                sb.append("Platina").append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}