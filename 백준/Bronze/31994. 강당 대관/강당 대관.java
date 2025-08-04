import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String maxSeminar = "";
        int maxCnt = 0;
        for (int i = 0; i < 7; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            String seminar = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            if (maxCnt < cnt) {
                maxCnt = cnt;
                maxSeminar = seminar;
            }
        }
        sb.append(maxSeminar);
        System.out.println(sb);
    }
}