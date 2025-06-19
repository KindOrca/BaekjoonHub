import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String[] A = new String[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) A[i] = st.nextToken();
        Arrays.sort(A, (a, b) -> (b + a).compareTo(a + b));
        for (int i = 0; i < N; ++i) sb.append(A[i]);
        System.out.println(sb.charAt(0) == '0' ? '0' : sb);
    }
}